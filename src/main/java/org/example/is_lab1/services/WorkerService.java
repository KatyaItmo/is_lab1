package org.example.is_lab1.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.is_lab1.daos.WorkerDao;
import org.example.is_lab1.entities.Worker;
import org.example.is_lab1.exceptions.NotFoundException;

import java.util.List;

@Stateless
public class WorkerService {

    @Inject
    private WorkerDao workerDao;

    public List<Worker> findAll() {
        return workerDao.findAll();
    }

    public Worker findById(Integer id) {
        return workerDao.findById(id)
                .orElseThrow(() -> new NotFoundException("worker с id " + id + " не найден"));
    }

    public Worker create(Worker worker) {
        return workerDao.create(worker);
    }
}
