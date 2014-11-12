package control;

import java.util.ArrayList;

import domain.Canal;

public class ChannelControl {

    Canal canal;

    public ChannelControl() {
    }

    public ChannelControl(Canal canal) {
        this.canal = canal;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }
    
    public boolean hasCanal(){
        if(canal == null) return false;
        return true;
    }
    
    public ArrayList<Canal> selectAll() {
        return new ArrayList(Conexao.namedQuery("Canal.findAll"));
    }

    
    
}
