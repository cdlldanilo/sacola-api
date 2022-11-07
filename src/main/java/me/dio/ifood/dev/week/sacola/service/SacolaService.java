package me.dio.ifood.dev.week.sacola.service;

import me.dio.ifood.dev.week.sacola.model.Item;
import me.dio.ifood.dev.week.sacola.model.Sacola;
import me.dio.ifood.dev.week.sacola.resource.dto.ItemDto;

public interface SacolaService {
    Item incluirItemNaSacola(ItemDto itemDto);
    Sacola verSacola(Long id);
    Sacola fecharSacola(Long id, int formaPagamento);
}