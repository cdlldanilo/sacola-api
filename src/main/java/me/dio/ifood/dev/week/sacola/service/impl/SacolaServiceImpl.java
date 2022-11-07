package me.dio.ifood.dev.week.sacola.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.dev.week.sacola.enumeration.FormaPagamento;
import me.dio.ifood.dev.week.sacola.model.Item;
import me.dio.ifood.dev.week.sacola.model.Restaurante;
import me.dio.ifood.dev.week.sacola.model.Sacola;
import me.dio.ifood.dev.week.sacola.repository.ItemRepository;
import me.dio.ifood.dev.week.sacola.repository.ProdutoRepository;
import me.dio.ifood.dev.week.sacola.repository.SacolaRepository;
import me.dio.ifood.dev.week.sacola.resource.dto.ItemDto;
import me.dio.ifood.dev.week.sacola.service.SacolaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SacolaServiceImpl implements SacolaService {
    private final SacolaRepository sacolaRepository;
    private final ProdutoRepository produtoRepository;

    private final ItemRepository itemRepository;

    @Override
    public Item incluirItemNaSacola(ItemDto itemDto) {
        Sacola sacola = verSacola(itemDto.getSacolaId());
        return null;
    }

    @Override
    public Sacola verSacola(Long id) {

        return sacolaRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("Essa sacola não existe!");
                }
        );
    }

    @Override
    public Sacola fecharSacola(Long id, int numeroformaPagamento) {
        Sacola sacola = verSacola(id);

        if(sacola.getItens().isEmpty()) {
            throw new RuntimeException("Inclua itens na sacola!");
        }

        FormaPagamento formaPagamento =
                numeroformaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;
        sacola.setFormaPagamento(formaPagamento);
        sacola.setFechada(true);
        return sacolaRepository.save(sacola);

    }
}
