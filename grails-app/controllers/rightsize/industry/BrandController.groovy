package rightsize.industry

import control.BrandControl
import control.ChannelControl
import domain.Canal
import domain.Marca

class BrandController {
    BrandControl marcaControl = new BrandControl();
    ChannelControl canalControl = new ChannelControl();
	
    ArrayList<Canal> listaDeCanais = canalControl.selectAll();
    ArrayList<Marca> brandList = new ArrayList<Marca>();
	
    def channelList = new ArrayList();
    def ageList = 4..80
    

    def LOREN_IPSUM = "Lorem ipsum"
	
    def index() { 
	brandList = loadBrand();

        [brandList: brandList]
    }

    def edit() { 
        Long id = null;
        Marca brand = new Marca();
        
        try{
            println(params.brandId);   
            id = new Long(params.brandId);
            brand = marcaControl.findById(id);
        }catch(Exception e){
            //TODO tratar a exceção de cast nulo
        }
		
    	channelList = loadChannels(brand); 
        
        return [brand: brand , channelList: channelList, ageList: ageList, listaDeCanais: listaDeCanais]
    }

    def create() {
		println(params.teste);
//		String nomeMarca = tablebody.gsp.campo1.gettext();
//		//
//		//
//		
//		
//		
//		
//		Marca m1 = new Marca();
//		m1.setNome(nomeMarca);
//		//
//		//
//		
//		marcaControl.add(m1);
		
    	//redirect(controller:"brand", action:"edit");
    }

    def loadBrand(){
    	return marcaControl.selectAll();
    }

    def loadChannels(Marca marca){
	//TODO fornecer os canais referentes a marca
        if(marca.getId() == null) return new ArrayList<Canal>();
        return marca.getMarcaCanalList();
    }
	 
    def merge(){
		println("Merjando");
	}
}
