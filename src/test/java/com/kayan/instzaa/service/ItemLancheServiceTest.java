package com.kayan.instzaa.service;

import com.kayan.instzaa.controller.dto.ItemLancheDTO;
import com.kayan.instzaa.domain.model.ItemLanche;
import com.kayan.instzaa.domain.repository.CardapioRepository;
import com.kayan.instzaa.domain.repository.ItemLancheRepository;
import jakarta.inject.Inject;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@SpringBootTest
class ItemLancheServiceTest {


    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void list() {
    }

    @Test
    void listPagination() {
    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
    }
}