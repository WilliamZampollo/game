package br.com.loft.game.http.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class SimplePersonageResponse {
    private int id;
    private String name;
    private String professionName;
    private boolean alive;
}
