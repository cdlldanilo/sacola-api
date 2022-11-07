package me.dio.ifood.dev.week.sacola.resource;

import lombok.RequiredArgsConstructor;
import me.dio.ifood.dev.week.sacola.model.Item;
import me.dio.ifood.dev.week.sacola.model.Sacola;
import me.dio.ifood.dev.week.sacola.resource.dto.ItemDto;
import me.dio.ifood.dev.week.sacola.service.SacolaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ifood-devweek/sacolas")
@RequiredArgsConstructor
public class SacolaResource {
    private final SacolaService sacolaService;

    @PostMapping
    public Item incluirItemNaSacola(@RequestBody ItemDto itemDto) {
        return sacolaService.incluirItemNaSacola(itemDto);
    }

    @GetMapping("/{id}")
    public Sacola verSacola(@PathVariable("id") Long id)  {

        return sacolaService.verSacola(id);
    }

    @PatchMapping("/fecharSacola/{sacolaId}")
    public Sacola fecharSacola(@PathVariable("sacolaId") Long sacolaId, @RequestParam("formaPagamento") int formaPagamento) {
        return sacolaService.fecharSacola(sacolaId, formaPagamento);
    }

}
