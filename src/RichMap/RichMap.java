package RichMap;

public abstract class RichMap {
    protected RichMapBuilder _mapBuilder;
    
    protected RichMap(RichMapBuilder mapBuilder){
        _mapBuilder = mapBuilder;        
    }

    public abstract int getSitesNumber();

    public abstract RichSite getSite(int index);

    public abstract String display();

    public abstract void buildMap();
}
