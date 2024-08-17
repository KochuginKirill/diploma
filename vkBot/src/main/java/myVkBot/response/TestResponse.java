package myVkBot.response;

import lombok.RequiredArgsConstructor;
import myVkBot.Client.WebStoreResponse;
import myVkBot.Constants;
import myVkBot.entites.Event;
import myVkBot.model.Product;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static myVkBot.Constants.WEB_STORE_URL;

public class TestResponse extends BasicResponse {



    public TestResponse(Event event, String accessToken, String productInfo) {
        super(event, accessToken, productInfo);
    }
    @Override
    protected List<NameValuePair> getQueryParameters() {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        if (super.getEvent().getEventObject().getText().equals("1")) {
            nameValuePairs.add(new BasicNameValuePair("message", "Адрес интернет магазина:" + WEB_STORE_URL + "\n"));
        }  else if(super.getEvent().getEventObject().getText().equals("2")) {
            nameValuePairs.add(new BasicNameValuePair("message", "Данный магазин предназначен для размещения товаров пользователями для последующей покупки\n"));
        } else if(super.getEvent().getEventObject().getText().equals("3")){
            nameValuePairs.add(new BasicNameValuePair("message", getProductInfo()));
        } else {
            nameValuePairs.add(new BasicNameValuePair("message", "Вы написали: " + super.getEvent().getEventObject().getText() + "\n"
                    + "Напишите цифру запроса:\n"
                    + "1) Написать адрес сайта магазина\n"
                    + "2) Краткое описание\n"
                    + "3) Список все товаров\n"
            ));
        }
        nameValuePairs.add(new BasicNameValuePair("peer_id", String.valueOf(super.getEvent().getEventObject().getUserId())));
        nameValuePairs.add(new BasicNameValuePair("access_token", super.getAccessToken()));
        nameValuePairs.add(new BasicNameValuePair("v", Constants.VK_API_VERSION));
        nameValuePairs.add(new BasicNameValuePair("random_id", String.valueOf(new SecureRandom().nextInt())));

        return nameValuePairs;
    }
}