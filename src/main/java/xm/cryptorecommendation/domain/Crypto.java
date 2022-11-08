package xm.cryptorecommendation.domain;

import io.swagger.v3.oas.annotations.media.Schema;

public class Crypto {
    private int id;
    @Schema(title = "User Name",name="name",required=true,defaultValue="test name")
    private String name;

    public Crypto(int id, String name) {
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Crypto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
