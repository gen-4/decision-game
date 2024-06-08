package com.gen4.pas.survival.models.dtos;

public class GetOrCreatePlayerDto {
    private Long id;
    private String name;
    
    public GetOrCreatePlayerDto() {
    }

    public GetOrCreatePlayerDto(Long id) {
        this.id = id;
    }

    public GetOrCreatePlayerDto(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
