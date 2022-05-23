package Request.Registry;

import Request.*;

import java.util.ArrayList;
import java.util.List;

public class ResponseRegistry {
    private int numberResponseForCallbackQuery; //номер сервиса от которого пришёл callback

    public int getNumberResponseForCallbackQuery() {
        return numberResponseForCallbackQuery;
    }
    public void setNumberResponseForCallbackQuery(int numberResponseForCallbackQuery) {
        this.numberResponseForCallbackQuery = numberResponseForCallbackQuery;
    }

    private List<Response> listResponse = new ArrayList<>(); //список всех методов

    public ResponseRegistry(){
        listResponse.add(new HelloRequest());
        listResponse.add(new ByeReqest());
        listResponse.add(new Covid());
        listResponse.add(new Courses());
        listResponse.add(new Weather());
        listResponse.add(new Time());
    }

    public int getSizeListResponse(){
        return listResponse.size();
    }

    public String getResponseName(int i){
        return listResponse.get(i).name();
    }

    public Response getResponse(int i){
        return listResponse.get(i);
    };
}

