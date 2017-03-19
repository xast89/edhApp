package com.magic;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 05.03.17.
 */
@Repository
public class CardRepository {

    private List<Card> dereviDeck = new ArrayList<>();

    public CardRepository() {
        createDereviDeck();

    }

    public List<Card> getDereviDeck() {
        return dereviDeck;
    }

    private void createDereviDeck() {
        //TODO: dodac x. y
        dereviDeck.add(createCard("Derevi, Empyrial Tactician", "c13_186", "http://magiccards.info/scans/en/c13/186.jpg"));
        dereviDeck.add(createCard("Forest", "151", "http://magiccards.info/scans/en/pca/151.jpg"));
        dereviDeck.add(createCard("Island", "137", "http://magiccards.info/scans/en/pca/137.jpg"));
        dereviDeck.add(createCard("Plains", "132", "http://magiccards.info/scans/en/pca/132.jpg"));
        dereviDeck.add(createCard("Fool's Demise", "111", "http://magiccards.info/scans/en/c14/111.jpg"));
        dereviDeck.add(createCard("Knight of New Alara", "70", "http://magiccards.info/scans/en/arb/70.jpg"));
        dereviDeck.add(createCard("Civic Saber ", "227", "http://magiccards.info/scans/en/rtr/227.jpg"));
        dereviDeck.add(createCard("Rancor", "76", "http://magiccards.info/scans/en/pca/76.jpg"));
        dereviDeck.add(createCard("Sylvan Caryatid", "180", "http://magiccards.info/scans/en/ths/180.jpg"));
//        dereviDeck.add(createCard("Mask of Avacyn", "229"));
//        dereviDeck.add(createCard("Trailblazer's Boots", "208"));
//        dereviDeck.add(createCard("Opportunity", "51"));
//        dereviDeck.add(createCard("Jace's Ingenuity", "63"));
//        dereviDeck.add(createCard("Brainstorm", "40"));
//        dereviDeck.add(createCard("Sakura-Tribe Elder", "164"));
//        dereviDeck.add(createCard("Simic Signet", "270"));
//        dereviDeck.add(createCard("Azorius Chancery", "282"));
//        dereviDeck.add(createCard("Silent Arbiter", "204"));
//        dereviDeck.add(createCard("Thornwood Falls", "333"));
//        dereviDeck.add(createCard("Forest", "151_2"));
//        dereviDeck.add(createCard("Grafted Wargear", "126"));
//        dereviDeck.add(createCard("Chitinous Cloak", "163"));
//        dereviDeck.add(createCard("Kodama's Reach", "155"));
//        dereviDeck.add(createCard("Day's Undoing", "51"));
//        dereviDeck.add(createCard("Angelic Destiny", "3"));
//        dereviDeck.add(createCard("Warped Landscape", "280"));
//        dereviDeck.add(createCard("Battle Mastery", "7"));
//        dereviDeck.add(createCard("Haunted Cloak", "257"));
//        dereviDeck.add(createCard("Gorgon Flail", "211"));
//        dereviDeck.add(createCard("Grafted Exoskeleton", "162"));
//        dereviDeck.add(createCard("Duelist's Heritage", "1"));
//        dereviDeck.add(createCard("Kaseto, Orochi Archmage", "47"));
//        dereviDeck.add(createCard("Forest", "151_3"));
//        dereviDeck.add(createCard("Darksteel Plate", "104"));
//        dereviDeck.add(createCard("Conqueror's Flail", "53"));
//        dereviDeck.add(createCard("Plains", "132_2"));
//        dereviDeck.add(createCard("Evolving Wilds", "294"));
//        dereviDeck.add(createCard("Sword of the Animist", "240"));
//        dereviDeck.add(createCard("Slab Hammer", "227"));
//        dereviDeck.add(createCard("Darksteel Ingot", "250"));
//        dereviDeck.add(createCard("Finest Hour", "126"));
//        dereviDeck.add(createCard("Life's Legacy", "183"));
//        dereviDeck.add(createCard("Bant Panorama", "276"));
//        dereviDeck.add(createCard("Seaside Citadel", "322"));
//        dereviDeck.add(createCard("Plains", "132_2"));
//        dereviDeck.add(createCard("Terramorphic Expanse", "129"));
//        dereviDeck.add(createCard("Fact or Fiction", "48"));
//        dereviDeck.add(createCard("Island", "137_2"));
//        dereviDeck.add(createCard("Island", "137_3"));
//        dereviDeck.add(createCard("Swiftfoot Boots", "277"));
//        dereviDeck.add(createCard("Forest", "151_4"));
//        dereviDeck.add(createCard("Island", "137_4"));
//        dereviDeck.add(createCard("Rapid Hybridization", "102"));
//        dereviDeck.add(createCard("Sejiri Refuge", "320"));
//        dereviDeck.add(createCard("Gift of Immortality", "14"));
//        dereviDeck.add(createCard("Selesnya Sanctuary", "125"));
//        dereviDeck.add(createCard("Island", "137_5"));
//        dereviDeck.add(createCard("Solemn Simulacrum", "273"));
//        dereviDeck.add(createCard("Loxodon Warhammer", "261"));
//        dereviDeck.add(createCard("Capsize", "42"));
//        dereviDeck.add(createCard("Bident of Thassa", "86"));
//        dereviDeck.add(createCard("Plains", "132_3"));
//        dereviDeck.add(createCard("Rogue's Passage", "220"));
//        dereviDeck.add(createCard("Spirit Loop", "43"));
//        dereviDeck.add(createCard("Fog Bank", "110"));
//        dereviDeck.add(createCard("Brilliant Halo", "19"));
//        dereviDeck.add(createCard("Plains", "132_4"));
//        dereviDeck.add(createCard("Azorius Guildgate", "275"));
//        dereviDeck.add(createCard("Chariot of Victory", "159"));
//        dereviDeck.add(createCard("Champion's Helm", "7"));
//        dereviDeck.add(createCard("Simic Growth Chamber", "326"));
//        dereviDeck.add(createCard("Moonsilver Spear", "251"));
//        dereviDeck.add(createCard("Unexpectedly Absent", "33"));
//        dereviDeck.add(createCard("Pongify", "120"));
//        dereviDeck.add(createCard("Plains", "132_5"));
//        dereviDeck.add(createCard("Windfall", "104"));
//        dereviDeck.add(createCard("Krosan Grip", "189"));
//        dereviDeck.add(createCard("Day of Judgment", "12"));
//        dereviDeck.add(createCard("Island", "137_6"));
//        dereviDeck.add(createCard("Commander's Sphere", "248"));
//        dereviDeck.add(createCard("Stonehewer Giant", "31"));
//        dereviDeck.add(createCard("Command Tower", "286"));
//        dereviDeck.add(createCard("Whirler Rogue", "83"));
//        dereviDeck.add(createCard("Fumigate", "15"));
//        dereviDeck.add(createCard("Windborn Muse", "80"));
//        dereviDeck.add(createCard("Plains", "132_6"));
//        dereviDeck.add(createCard("Forest", "151_5"));
//        dereviDeck.add(createCard("Island", "137_7"));
//        dereviDeck.add(createCard("Blossoming Sands", "237"));
//        dereviDeck.add(createCard("Island", "137_8"));
//        dereviDeck.add(createCard("Forest", "151_6"));
//        dereviDeck.add(createCard("Wrath of God", "38"));
//        dereviDeck.add(createCard("Evacuation", "91"));
//        dereviDeck.add(createCard("Forest", "151_7"));
//        dereviDeck.add(createCard("Telling Time", "61"));
//        dereviDeck.add(createCard("Mulldrifter", "97"));
//        dereviDeck.add(createCard("Thassa, God of the Sea", "66"));
//        dereviDeck.add(createCard("Rafiq of the Many", "10"));
//        dereviDeck.add(createCard("Geist of the Archives", "62"));
//        dereviDeck.add(createCard("Hero's Blade", "160"));

    }

    private Card createCard(String name, String number, String src) {
        return new Card(name, number, src);
    }
}
