package control;

import java.util.ArrayList;

import domain.Canal;

public class ChannelControl {
	
	public ArrayList<Canal> selectAll(){
		return new ArrayList(Conexao.namedQuery("Canal.findAll"));
	}

}
