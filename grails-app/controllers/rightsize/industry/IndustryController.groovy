package rightsize.industry

class IndustryController {

    def channelList = new ArrayList();
    def additionalList = new ArrayList();
    def countryList = new ArrayList();
    def stateList = new ArrayList();
    def cityList = new ArrayList();

    def LOREN_IPSUM = "Lorem ipsum"
	
    def index() { 
    	
    }

    def edit() { 

    	channelList = loadChannels();
    	additionalList = loadAdditionalInfo();
        countryList = loadCountry();
        stateList = loadState();
        cityList = loadCity();

    	[channelList: channelList, 
        additionalList: additionalList,
        countryList: countryList,
        stateList: stateList,
        cityList: cityList
        ]
    	
    }

    def create() { 
    	redirect(controller:"brand", action:"edit");
    }

    def loadChannels(){
        
        channelList = new ArrayList();
        for ( i in 0..3 ) {
            channelList.add(LOREN_IPSUM + " " + i);
        }
        return channelList
    }

    def loadAdditionalInfo(){
        
        additionalList = new ArrayList();
        for ( i in 0..3 ) {
            additionalList.add(LOREN_IPSUM + " " + i);
        }
        return additionalList
    }

    def loadCountry(){
        countryList = new ArrayList();
        for ( i in 0..3 ) {
            countryList.add(LOREN_IPSUM + " " + i);
        }
        return countryList
    }

    def loadState(){
        stateList = new ArrayList();
        
        stateList.add("AM");
        stateList.add("RJ");
        stateList.add("SC");
        stateList.add("SP");
        stateList.add(LOREN_IPSUM);
        stateList.add(LOREN_IPSUM);
        return stateList
    }

    def loadCity(){
        cityList = new ArrayList();
        for ( i in 0..3 ) {
            cityList.add(LOREN_IPSUM + " " + i);
        }
        return cityList
    }




    
}
