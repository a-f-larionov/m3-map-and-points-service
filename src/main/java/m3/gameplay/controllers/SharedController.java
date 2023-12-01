package m3.gameplay.controllers;

import lombok.RequiredArgsConstructor;
import m3.gameplay.dto.rs.DoOrderChangeAnswerRsDto;
import m3.gameplay.services.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SharedController {

    private final PaymentService paymentService;

    @GetMapping("/service/standalone_buy")
    @ResponseBody
    public DoOrderChangeAnswerRsDto standaloneBuy(@RequestParam("receiver_id") Long socNetUserId,
                                                  @RequestParam("order_id") Long orderId,
                                                  @RequestParam("item_price") Long itemPrice) {
        return paymentService.standaloneBuy(socNetUserId, orderId, itemPrice);
    }

    @GetMapping("/service/vk_buy")
    @ResponseBody
    public DoOrderChangeAnswerRsDto vkBuy(
            @RequestParam("app_id") Long appId,
            @RequestParam("receiver_id") Long socNetUserId,
            @RequestParam("sig") String sig,
            @RequestParam("order_id") Long orderId,
            @RequestParam("item_price") Long itemPrice,
            @RequestParam("notification_type") String notificationType,
            @RequestParam("status") String status
    ) {
        //@todo how do it by one string from getParams\or may be Post?
        Map<String, String> params = Map.of(
                "app_id", appId.toString(),
                "receiver_id", socNetUserId.toString(),
                "sig", sig,
                "order_id", orderId.toString(),
                "item_price", itemPrice.toString(),
                "notification_type", notificationType,
                "status", status);
        return paymentService.vkBuy(appId, socNetUserId, sig, orderId, itemPrice, notificationType, status, params);
    }
}