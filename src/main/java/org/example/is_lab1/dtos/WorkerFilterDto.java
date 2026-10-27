package org.example.is_lab1.dtos;

public class WorkerFilterDto {
    private String name;
    private String sortDirection;

    public WorkerFilterDto() {}

    public WorkerFilterDto(String name, String sortDirection) {
        this.name = name;
        this.sortDirection = sortDirection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }
}
