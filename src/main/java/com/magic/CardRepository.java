package com.magic;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 05.03.17.
 */
@Repository
public class CardRepository
{

    private static final String NEW_LINE = "&#013;";

    private List<Card> dereviDeck;

    public CardRepository()
    {
        this.dereviDeck = createDereviDeck();

    }

    public List<Card> getDereviDeck()
    {
        return dereviDeck;
    }

    private List<Card> createDereviDeck() {

        List<Card> dereviDeckTemp = new ArrayList<>();

        dereviDeckTemp.add(createCard("Forest", "pca_151", "cards/green/forest.jpg", "Add G to your mana pool"));
        dereviDeckTemp.add(createCard("Island", "pca_137", "cards/blue/island.jpg" , "Add U to your mana pool"));
        dereviDeckTemp.add(createCard("Plains", "pca_132","cards/white/plains.jpg" , "Add W to your mana pool"));
        dereviDeckTemp.add(createCard("Rancor", "pca_76", "cards/green/rancor.jpg", "Enchant creature"+NEW_LINE+"Enchanted creature gets +2/+0 and has trample."+NEW_LINE+"When Rancor is put into a graveyard from the battlefield, return Rancor to its owner's hand."));
//        dereviDeckTemp.add(createCard("Fool's Demise", "c14_111", "http://magiccards.info/scans/en/c14/111.jpg"));
//        dereviDeckTemp.add(createCard("Knight of New Alara", "arb_70", "http://magiccards.info/scans/en/arb/70.jpg"));
//        dereviDeckTemp.add(createCard("Civic Saber ", "rtr_227", "http://magiccards.info/scans/en/rtr/227.jpg"));
//        dereviDeckTemp.add(createCard("Sylvan Caryatid", "ths_180", "http://magiccards.info/scans/en/ths/180.jpg"));
//        dereviDeckTemp.add(createCard("Mask of Avacyn", "isd_229", "http://magiccards.info/scans/en/isd/229.jpg"));
//        dereviDeckTemp.add(createCard("Trailblazer's Boots", "zen_208", "http://magiccards.info/scans/en/zen/208.jpg"));
//        dereviDeckTemp.add(createCard("Opportunity", "c13_51", "http://magiccards.info/scans/en/c13/51.jpg"));
//        dereviDeckTemp.add(createCard("Jace's Ingenuity", "m15_63", "http://magiccards.info/scans/en/m15/63.jpg"));
//        dereviDeckTemp.add(createCard("Brainstorm", "ema_40", "http://magiccards.info/scans/en/ema/40.jpg"));
//        dereviDeckTemp.add(createCard("Sakura-Tribe Elder", "164", "http://magiccards.info/scans/en/c16/164.jpg"));
//        dereviDeckTemp.add(createCard("Simic Signet", "270", "http://magiccards.info/scans/en/c16/270.jpg"));
        dereviDeckTemp.add(createCard("Derevi, Empyrial Tactician",  "c13_186", "cards/multi/dereviEmpyrialTactician.jpg", "Flying"+NEW_LINE+"Whenever Derevi, Empyrial Tactician enters the battlefield or a creature you control deals combat damage to a player, you may tap or untap target permanent."+NEW_LINE+"{1}{G}{W}{U}: Put Derevi onto the battlefield from the command zone."));
//        dereviDeckTemp.add(createCard("Azorius Chancery", "282"));
//        dereviDeckTemp.add(createCard("Silent Arbiter", "204"));
//        dereviDeckTemp.add(createCard("Thornwood Falls", "333"));
//        dereviDeckTemp.add(createCard("Forest", "151_2"));
//        dereviDeckTemp.add(createCard("Grafted Wargear", "126"));
//        dereviDeckTemp.add(createCard("Chitinous Cloak", "163"));
//        dereviDeckTemp.add(createCard("Kodama's Reach", "155"));
//        dereviDeckTemp.add(createCard("Day's Undoing", "51"));
//        dereviDeckTemp.add(createCard("Angelic Destiny", "3"));
//        dereviDeckTemp.add(createCard("Warped Landscape", "280"));
//        dereviDeckTemp.add(createCard("Battle Mastery", "7"));
//        dereviDeckTemp.add(createCard("Haunted Cloak", "257"));
//        dereviDeckTemp.add(createCard("Gorgon Flail", "211"));
//        dereviDeckTemp.add(createCard("Grafted Exoskeleton", "162"));
//        dereviDeckTemp.add(createCard("Duelist's Heritage", "1"));
//        dereviDeckTemp.add(createCard("Kaseto, Orochi Archmage", "47"));
//        dereviDeckTemp.add(createCard("Forest", "151_3"));
//        dereviDeckTemp.add(createCard("Darksteel Plate", "104"));
//        dereviDeckTemp.add(createCard("Conqueror's Flail", "53"));
//        dereviDeckTemp.add(createCard("Plains", "132_2"));
//        dereviDeckTemp.add(createCard("Evolving Wilds", "294"));
//        dereviDeckTemp.add(createCard("Sword of the Animist", "240"));
//        dereviDeckTemp.add(createCard("Slab Hammer", "227"));
//        dereviDeckTemp.add(createCard("Darksteel Ingot", "250"));
//        dereviDeckTemp.add(createCard("Finest Hour", "126"));
//        dereviDeckTemp.add(createCard("Life's Legacy", "183"));
//        dereviDeckTemp.add(createCard("Bant Panorama", "276"));
//        dereviDeckTemp.add(createCard("Seaside Citadel", "322"));
//        dereviDeckTemp.add(createCard("Plains", "132_2"));
//        dereviDeckTemp.add(createCard("Terramorphic Expanse", "129"));
//        dereviDeckTemp.add(createCard("Fact or Fiction", "48"));
//        dereviDeckTemp.add(createCard("Island", "137_2"));
//        dereviDeckTemp.add(createCard("Island", "137_3"));
//        dereviDeckTemp.add(createCard("Swiftfoot Boots", "277"));
//        dereviDeckTemp.add(createCard("Forest", "151_4"));
//        dereviDeckTemp.add(createCard("Island", "137_4"));
//        dereviDeckTemp.add(createCard("Rapid Hybridization", "102"));
//        dereviDeckTemp.add(createCard("Sejiri Refuge", "320"));
//        dereviDeckTemp.add(createCard("Gift of Immortality", "14"));
//        dereviDeckTemp.add(createCard("Selesnya Sanctuary", "125"));
//        dereviDeckTemp.add(createCard("Island", "137_5"));
//        dereviDeckTemp.add(createCard("Solemn Simulacrum", "273"));
//        dereviDeckTemp.add(createCard("Loxodon Warhammer", "261"));
//        dereviDeckTemp.add(createCard("Capsize", "42"));
//        dereviDeckTemp.add(createCard("Bident of Thassa", "86"));
//        dereviDeckTemp.add(createCard("Plains", "132_3"));
//        dereviDeckTemp.add(createCard("Rogue's Passage", "220"));
//        dereviDeckTemp.add(createCard("Spirit Loop", "43"));
//        dereviDeckTemp.add(createCard("Fog Bank", "110"));
//        dereviDeckTemp.add(createCard("Brilliant Halo", "19"));
//        dereviDeckTemp.add(createCard("Plains", "132_4"));
//        dereviDeckTemp.add(createCard("Azorius Guildgate", "275"));
//        dereviDeckTemp.add(createCard("Chariot of Victory", "159"));
//        dereviDeckTemp.add(createCard("Champion's Helm", "7"));
//        dereviDeckTemp.add(createCard("Simic Growth Chamber", "326"));
//        dereviDeckTemp.add(createCard("Moonsilver Spear", "251"));
//        dereviDeckTemp.add(createCard("Unexpectedly Absent", "33"));
//        dereviDeckTemp.add(createCard("Pongify", "120"));
//        dereviDeckTemp.add(createCard("Plains", "132_5"));
//        dereviDeckTemp.add(createCard("Windfall", "104"));
//        dereviDeckTemp.add(createCard("Krosan Grip", "189"));
//        dereviDeckTemp.add(createCard("Day of Judgment", "12"));
//        dereviDeckTemp.add(createCard("Island", "137_6"));
//        dereviDeckTemp.add(createCard("Commander's Sphere", "248"));
//        dereviDeckTemp.add(createCard("Stonehewer Giant", "31"));
//        dereviDeckTemp.add(createCard("Command Tower", "286"));
//        dereviDeckTemp.add(createCard("Whirler Rogue", "83"));
//        dereviDeckTemp.add(createCard("Fumigate", "15"));
//        dereviDeckTemp.add(createCard("Windborn Muse", "80"));
//        dereviDeckTemp.add(createCard("Plains", "132_6"));
//        dereviDeckTemp.add(createCard("Forest", "151_5"));
//        dereviDeckTemp.add(createCard("Island", "137_7"));
//        dereviDeckTemp.add(createCard("Blossoming Sands", "237"));
//        dereviDeckTemp.add(createCard("Island", "137_8"));
//        dereviDeckTemp.add(createCard("Forest", "151_6"));
//        dereviDeckTemp.add(createCard("Wrath of God", "38"));
//        dereviDeckTemp.add(createCard("Evacuation", "91"));
//        dereviDeckTemp.add(createCard("Forest", "151_7"));
//        dereviDeckTemp.add(createCard("Telling Time", "61"));
//        dereviDeckTemp.add(createCard("Mulldrifter", "97"));
//        dereviDeckTemp.add(createCard("Thassa, God of the Sea", "66"));
//        dereviDeckTemp.add(createCard("Rafiq of the Many", "10"));
//        dereviDeckTemp.add(createCard("Geist of the Archives", "62"));
//        dereviDeckTemp.add(createCard("Hero's Blade", "160"));

        return dereviDeckTemp;

    }

    private Card createCard(String name, String number, String src, String skill)
    {
        return new Card(name, number, src, skill);
    }
}
