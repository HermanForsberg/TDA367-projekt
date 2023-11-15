package Controller;

import Model.FlashcardFeature;

public class FlashcardFeatureController {

    private FlashcardFeature model;
    public FlashcardFeatureController(FlashcardFeature model){
        this.model = model;
    }

    public void addClicked(String deckName){
        model.addClicked(deckName);

    }
    public void deck1Clicked(){

    }

    }
