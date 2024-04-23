package hello.itemservice.domain.item.controller;

import hello.itemservice.domain.item.service.ItemService;
import hello.itemservice.domain.item.vo.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor // 생성자 만들어줌
public class BasicItemController {

    //생성자 주입
    private final ItemService itemService;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable("itemId") long itemId, Model model) {
        Item item = itemService.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    //@PostMapping("/add")
    public String addItemV1(@RequestParam("itemName") String itemName, @RequestParam("price") int price, @RequestParam("quantity") Integer quantity, Model model) {

        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemService.save(item);

        model.addAttribute("item", item);


        return "basic/item";
    }

    //@PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item, Model model) {

        itemService.save(item);

        // 자동 추가, 생략 가능
        //model.addAttribute("item", item);


        return "basic/item";
    }

    //@PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item) {

        itemService.save(item);
        // 자동 추가, 생략 가능
        return "basic/item";
    }

    /**
     * @param item
     * @return view
     * <p>
     * 웹 브라우저의 새로 고침은 마지막에 서버에 전송한 데이터를 다시 전송함 -> 새로고침을 하게 되면, POST /add + 상품 데이터를 계속 다시 전송하게 됨
     */
    //@PostMapping("/add")
    public String addItemV4(Item item) {

        itemService.save(item);

        return "basic/item";
    }

    //@PostMapping("/add")
    public String addItemV5(Item item) {

        itemService.save(item);

        return "redirect:/basic/items/" + item.getId();
    }

    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {

        Item saveditem = itemService.save(item);
        redirectAttributes.addAttribute("itemId", saveditem.getId());
        redirectAttributes.addAttribute("status", true);

        return "redirect:/basic/items/{itemId}";
    }


    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable("itemId") Long itemId, Model model) {
        Item item = itemService.findById(itemId);
        model.addAttribute("item", item);

        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable("itemId") Long itemId, Item item) {
        itemService.update(itemId, item);

        return "redirect:/basic/items/{itemId}";
    }


    // Bean 라이프사이클에서 오직 한번만 수행된다는 것을 보장할 수 있음 -> 딱1 번 초기화
//    @PostConstruct
//    public void init() {
//        log.debug("@PostConstruct 내 init() 실행");
//        itemService.save(new Item("ItemA", 10000, 10));
//        itemService.save(new Item("ItemB", 20000, 20));
//
//    }


}
