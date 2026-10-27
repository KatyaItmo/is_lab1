package org.example.is_lab1.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.is_lab1.daos.CoordinatesDao;
import org.example.is_lab1.daos.OrganizationDao;
import org.example.is_lab1.daos.PersonDao;
import org.example.is_lab1.daos.WorkerDao;
import org.example.is_lab1.dtos.WorkerDto;
import org.example.is_lab1.dtos.WorkerFilterDto;
import org.example.is_lab1.entities.*;
import org.example.is_lab1.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
@Transactional
public class WorkerService {

    @Inject
    private WorkerDao workerDao;

    @Inject
    private OrganizationDao organizationDao;

    @Inject
    private PersonDao personDao;

    @Inject
    private CoordinatesDao coordinatesDao;

    public List<WorkerDto> getFilteredAndSortedWorkers(WorkerFilterDto filter) {
        String nameFilter = filter != null ? filter.getName() : null;
        String sortDir = filter != null ? filter.getSortDirection() : null;

        List<Worker> workers = workerDao.findFilteredAndSorted(nameFilter, sortDir);
        return workers.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Worker getWorkerEntityById(Integer id) {
        return workerDao.findById(id)
                .orElseThrow(() -> new NotFoundException("worker с id " + id + " не найден"));
    }

    public WorkerDto createWorker(WorkerDto dto) {
        Worker worker = new Worker();
        mapDtoToEntity(dto, worker);
        Worker saved = workerDao.create(worker);
        return convertToDto(saved);
    }

    public WorkerDto updateWorker(Integer id, WorkerDto dto) {
        Worker worker = getWorkerEntityById(id);
        mapDtoToEntity(dto, worker);
        Worker updated = workerDao.update(worker);
        return convertToDto(updated);
    }

    public void deleteWorker(Integer id) {
        Worker worker = getWorkerEntityById(id);
        workerDao.delete(worker);
    }


    public Double getAverageRating() {
        return workerDao.getAverageRating();
    }

    public Long countByStatusLessThan(Status status) {
        return workerDao.countByStatusLessThan(status);
    }

    public List<Status> getUniqueStatuses() {
        return workerDao.getUniqueStatuses();
    }

    public WorkerDto fireWorker(Integer id) {
        Worker worker = getWorkerEntityById(id);
        worker.setStatus(Status.FIRED);
        Worker updated = workerDao.update(worker);
        return convertToDto(updated);
    }

    public WorkerDto indexSalary(Integer id, double coefficient) {
        if (coefficient <= 0) {
            throw new IllegalArgumentException("коэффициент индексации должен быть больше 0");
        }
        Worker worker = getWorkerEntityById(id);
        int newSalary = (int) Math.round(worker.getSalary() * coefficient);
        worker.setSalary(newSalary);
        Worker updated = workerDao.update(worker);
        return convertToDto(updated);
    }


    private WorkerDto convertToDto(Worker worker) {
        WorkerDto dto = new WorkerDto();
        dto.setId(worker.getId());
        dto.setName(worker.getName());

        if (worker.getCoordinates() != null) {
            dto.setIdCoordinates(worker.getCoordinates().getId());
        }

        if (worker.getCreationDate() != null) {
            dto.setCreationDate(worker.getCreationDate().toString());
        }

        if (worker.getOrganization() != null) {
            dto.setIdOrganization(worker.getOrganization().getId());
        }

        dto.setSalary(worker.getSalary());
        dto.setRating(worker.getRating());

        if (worker.getStartDate() != null) {
            dto.setStartDate(worker.getStartDate().toString());
        }

        dto.setPosition(worker.getPosition());
        dto.setStatus(worker.getStatus());

        if (worker.getPerson() != null) {
            dto.setIdPerson(worker.getPerson().getId());
        }

        return dto;
    }

    private void mapDtoToEntity(WorkerDto dto, Worker worker) {
        worker.setName(dto.getName());

        if (dto.getIdCoordinates() != null) {
            Coordinates coordinates = coordinatesDao.findById(dto.getIdCoordinates())
                    .orElseThrow(() -> new NotFoundException("coordinates с id " + dto.getIdCoordinates() + " не найдены"));
            worker.setCoordinates(coordinates);
        } else {
            throw new IllegalArgumentException("поле idCoordinates не может быть пустым");
        }

        worker.setSalary(dto.getSalary());
        worker.setRating(dto.getRating());

        if (dto.getStartDate() != null && !dto.getStartDate().isBlank()) {
            worker.setStartDate(java.time.ZonedDateTime.parse(dto.getStartDate()));
        }

        worker.setPosition(dto.getPosition());
        worker.setStatus(dto.getStatus());

        if (dto.getIdOrganization() != null) {
            Organization org = organizationDao.findById(dto.getIdOrganization())
                    .orElseThrow(() -> new NotFoundException("organization с id " + dto.getIdOrganization() + " не найдена"));
            worker.setOrganization(org);
        } else {
            worker.setOrganization(null);
        }

        if (dto.getIdPerson() != null) {
            Person person = personDao.findById(dto.getIdPerson())
                    .orElseThrow(() -> new NotFoundException("person с id " + dto.getIdPerson() + " не найдена"));
            worker.setPerson(person);
        } else {
            throw new IllegalArgumentException("поле idPerson не может быть пустым");
        }
    }
}