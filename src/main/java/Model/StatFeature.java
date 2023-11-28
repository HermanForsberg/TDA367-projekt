package Model;

public class StatFeature {

    private StatisticModel statModel;

    public StatFeature(StatisticModel model){
        this.statModel = model;
    }
    public StatisticModel getModel(){
        return statModel;
    }
}
