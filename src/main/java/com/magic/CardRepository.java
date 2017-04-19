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

    private List<Card> createDereviDeck()
    {

        List<Card> dereviDeckTemp = new ArrayList<>();

        dereviDeckTemp.add(createCard("Forest", "forest", "cards/land/forest.jpg"));
        dereviDeckTemp.add(createCard("Island", "island", "cards/land/island.jpg"));
        dereviDeckTemp.add(createCard("Plains", "plains", "cards/land/plains.jpg"));
        dereviDeckTemp.add(createCard("Plains", "plains_2", "cards/land/plains.jpg"));
        dereviDeckTemp.add(createCard("Rancor", "rancor", "cards/green/enchantment/rancor.jpg"));
        dereviDeckTemp.add(createCard("Arcane Denial", "arcaneDenial", "cards/blue/instant/arcaneDenial.jpg"));
        dereviDeckTemp.add(createCard("Knight of New Alara", "knightOfNewAlara", "cards/multi/creature/knightOfNewAlara.jpg"));
        dereviDeckTemp.add(createCard("Civic Saber", "civicSaber", "cards/colorless/artifact/civicSaber.jpg"));
        dereviDeckTemp.add(createCard("Sylvan Caryatid", "sylvanCaryatid", "cards/green/creature/sylvanCaryatid.jpg"));
        dereviDeckTemp.add(createCard("Mask of Avacyn", "maskOfAvacyn", "cards/colorless/artifact/maskOfAvacyn.jpg"));
        dereviDeckTemp.add(createCard("Trailblazer's Boots", "trailblazersBoots", "cards/colorless/artifact/trailblazersBoots.jpg"));
        dereviDeckTemp.add(createCard("Opportunity", "opportunity", "cards/blue/instant/opportunity.jpg"));
        dereviDeckTemp.add(createCard("Jace's Ingenuity", "jacesIngenuity", "cards/blue/instant/jacesIngenuity.jpg"));
        dereviDeckTemp.add(createCard("Brainstorm", "brainstorm", "cards/blue/instant/brainstorm.jpg"));
        dereviDeckTemp.add(createCard("Sakura-Tribe Elder", "sakura-TribeElder", "cards/green/creature/sakura-TribeElder.jpg"));
        dereviDeckTemp.add(createCard("Simic Signet", "simicSignet", "cards/colorless/artifact/simicSignet.jpg"));
        dereviDeckTemp.add(createCard("Azorius Chancery", "azoriusChancery", "cards/land/azoriusChancery.jpg"));
        dereviDeckTemp.add(createCard("Silent Arbiter", "silentArbiter", "cards/colorless/creature/silentArbiter.jpg"));
        dereviDeckTemp.add(createCard("Thornwood Falls", "thornwoodFalls", "cards/land/thornwoodFalls.jpg"));
        dereviDeckTemp.add(createCard("Forest", "forest_2", "cards/land/forest.jpg"));
        dereviDeckTemp.add(createCard("Grafted Wargear", "graftedWargear", "cards/colorless/artifact/graftedWargear.jpg"));
        dereviDeckTemp.add(createCard("Chitinous Cloak", "chitinousCloak", "cards/colorless/artifact/chitinousCloak.jpg"));
        dereviDeckTemp.add(createCard("Kodama's Reach", "kodamasReach", "cards/green/sorcery/kodamasReach.jpg"));
        dereviDeckTemp.add(createCard("Day's Undoing", "daysUndoing", "cards/blue/sorcery/daysUndoing.jpg"));
        dereviDeckTemp.add(createCard("Angelic Destiny", "angelicDestiny", "cards/white/enchantment/angelicDestiny.jpg"));
        dereviDeckTemp.add(createCard("Warped Landscape", "warpedLandscape", "cards/land/warpedLandscape.jpg"));
        dereviDeckTemp.add(createCard("Battle Mastery", "battleMastery", "cards/white/enchantment/battleMastery.jpg"));
        dereviDeckTemp.add(createCard("Haunted Cloak", "hauntedCloak", "cards/colorless/artifact/hauntedCloak.jpg"));
        dereviDeckTemp.add(createCard("Gorgon Flail", "gorgonFlail", "cards/colorless/artifact/gorgonFlail.jpg"));
        dereviDeckTemp.add(createCard("Grafted Exoskeleton", "graftedExoskeleton", "cards/colorless/artifact/graftedExoskeleton.jpg"));
        dereviDeckTemp.add(createCard("Duelist's Heritage", "duelistsHeritage", "cards/white/enchantment/duelistsHeritage.jpg"));
        dereviDeckTemp.add(createCard("Kaseto, Orochi Archmage", "kasetoOrochiArchmage", "cards/multi/creature/kasetoOrochiArchmage.jpg"));
        dereviDeckTemp.add(createCard("Forest", "forest_3", "cards/land/forest.jpg"));
        dereviDeckTemp.add(createCard("Darksteel Plate", "darksteelPlate", "cards/colorless/artifact/darksteelPlate.jpg"));
        dereviDeckTemp.add(createCard("Conqueror's Flail", "conquerorsFlail", "cards/colorless/artifact/conquerorsFlail.jpg"));
        dereviDeckTemp.add(createCard("Plains", "plains_3", "cards/land/plains.jpg"));
        dereviDeckTemp.add(createCard("Evolving Wilds", "evolvingWilds", "cards/land/evolvingWilds.jpg"));
        dereviDeckTemp.add(createCard("Sword of the Animist", "swordOfTheAnimist", "cards/colorless/artifact/swordOfTheAnimist.jpg"));
        dereviDeckTemp.add(createCard("Slab Hammer", "slabHammer", "cards/colorless/artifact/slabHammer.jpg"));
        dereviDeckTemp.add(createCard("Darksteel Ingot", "darksteelIngot", "cards/colorless/artifact/darksteelIngot.jpg"));
        dereviDeckTemp.add(createCard("Finest Hour", "finestHour", "cards/multi/enchantment/finestHour.jpg"));
        dereviDeckTemp.add(createCard("Life's Legacy", "lifesLegacy", "cards/green/sorcery/lifesLegacy.jpg"));
        dereviDeckTemp.add(createCard("Bant Panorama", "bantPanorama", "cards/land/bantPanorama.jpg"));
        dereviDeckTemp.add(createCard("Seaside Citadel", "seasideCitadel", "cards/land/seasideCitadel.jpg"));
        dereviDeckTemp.add(createCard("Plains", "plains_4", "cards/land/plains.jpg"));
        dereviDeckTemp.add(createCard("Terramorphic Expanse", "terramorphicExpanse", "cards/land/terramorphicExpanse.jpg"));
        dereviDeckTemp.add(createCard("Fact or Fiction", "factOrFiction", "cards/blue/instant/factOrFiction.jpg"));
        dereviDeckTemp.add(createCard("Island", "island_2", "cards/land/island.jpg"));
        dereviDeckTemp.add(createCard("Island", "island_3", "cards/land/island.jpg"));
        dereviDeckTemp.add(createCard("Swiftfoot Boots", "swiftfootBoots", "cards/colorless/artifact/swiftfootBoots.jpg"));
        dereviDeckTemp.add(createCard("Forest", "forest_4", "cards/land/forest.jpg"));
        dereviDeckTemp.add(createCard("Island", "island_4", "cards/land/island.jpg"));
        dereviDeckTemp.add(createCard("Rapid Hybridization", "rapidHybridization", "cards/blue/instant/rapidHybridization.jpg"));
        dereviDeckTemp.add(createCard("Sejiri Refuge", "sejiriRefuge", "cards/land/sejiriRefuge.jpg"));
        dereviDeckTemp.add(createCard("Gift of Immortality", "giftOfImmortality", "cards/white/enchantment/giftOfImmortality.jpg"));
        dereviDeckTemp.add(createCard("Selesnya Sanctuary", "selesnyaSanctuary", "cards/land/selesnyaSanctuary.jpg"));
        dereviDeckTemp.add(createCard("Island", "island_5", "cards/land/island.jpg"));
        dereviDeckTemp.add(createCard("Solemn Simulacrum", "solemnSimulacrum", "cards/colorless/artifact/solemnSimulacrum.jpg"));
        dereviDeckTemp.add(createCard("Loxodon Warhammer", "loxodonWarhammer", "cards/colorless/artifact/loxodonWarhammer.jpg"));
        dereviDeckTemp.add(createCard("Capsize", "capsize", "cards/blue/instant/capsize.jpg"));
        dereviDeckTemp.add(createCard("Bident of Thassa", "bidentOfThassa", "cards/blue/artifact/bidentOfThassa.jpg"));
        dereviDeckTemp.add(createCard("Plains", "plains_5", "cards/land/plains.jpg"));
        dereviDeckTemp.add(createCard("Rogue's Passage", "roguesPassage", "cards/land/roguesPassage.jpg"));
        dereviDeckTemp.add(createCard("Spirit Loop", "spiritLoop", "cards/white/enchantment/spiritLoop.jpg"));
        dereviDeckTemp.add(createCard("Fog Bank", "fogBank", "cards/blue/creature/fogBank.jpg"));
        dereviDeckTemp.add(createCard("Brilliant Halo", "brilliantHalo", "cards/white/enchantment/brilliantHalo.jpg"));
        dereviDeckTemp.add(createCard("Plains", "plains_6", "cards/land/plains.jpg"));
        dereviDeckTemp.add(createCard("Azorius Guildgate", "azoriusGuildgate", "cards/land/azoriusGuildgate.jpg"));
        dereviDeckTemp.add(createCard("Chariot of Victory", "chariotOfVictory", "cards/colorless/artifact/chariotOfVictory.jpg"));
        dereviDeckTemp.add(createCard("Champion's Helm", "championsHelm", "cards/colorless/artifact/championsHelm.jpg"));
        dereviDeckTemp.add(createCard("Simic Growth Chamber", "simicgrowthChamber", "cards/land/simicgrowthChamber.jpg"));
        dereviDeckTemp.add(createCard("Moonsilver Spear", "moonsilverSpear", "cards/colorless/artifact/moonsilverSpear.jpg"));
        dereviDeckTemp.add(createCard("Unexpectedly Absent", "unexpectedlyAbsent", "cards/white/instant/unexpectedlyAbsent.jpg"));
        dereviDeckTemp.add(createCard("Pongify", "pongify", "cards/blue/instant/pongify.jpg"));
        dereviDeckTemp.add(createCard("Plains", "plains_7", "cards/land/plains.jpg"));
        dereviDeckTemp.add(createCard("Windfall", "windfall", "cards/blue/instant/windfall.jpg"));
        dereviDeckTemp.add(createCard("Krosan Grip", "krosanGrip", "cards/green/instant/krosanGrip.jpg"));
        dereviDeckTemp.add(createCard("Day of Judgment", "dayOfJudgment", "cards/white/sorcery/dayOfJudgment.jpg"));
        dereviDeckTemp.add(createCard("Island", "island_6", "cards/land/island.jpg"));
        dereviDeckTemp.add(createCard("Commander's Sphere", "commandersSphere", "cards/colorless/artifact/commandersSphere.jpg"));
        dereviDeckTemp.add(createCard("Stonehewer Giant", "stonehewerGiant", "cards/white/creature/stonehewerGiant.jpg"));
        dereviDeckTemp.add(createCard("Command Tower", "commandTower", "cards/land/commandTower.jpg"));
//        dereviDeckTemp.add(createCard("Whirler Rogue", "whirlerRogue", "cards/blue/creature/whirlerRogue.jpg"));
        dereviDeckTemp.add(createCard("Wrath of God", "wrathOfGod", "cards/white/sorcery/wrathOfGod.jpg"));
        dereviDeckTemp.add(createCard("Windborn Muse", "windbornMuse", "cards/white/creature/windbornMuse.jpg"));
        dereviDeckTemp.add(createCard("Plains", "plains_8", "cards/land/plains.jpg"));
        dereviDeckTemp.add(createCard("Forest", "forest_5", "cards/land/forest.jpg"));
        dereviDeckTemp.add(createCard("Island", "island_7", "cards/land/island.jpg"));
        dereviDeckTemp.add(createCard("Blossoming Sands", "blossomingSands", "cards/land/blossomingSands.jpg"));
        dereviDeckTemp.add(createCard("Island", "island_8", "cards/land/island.jpg"));
        dereviDeckTemp.add(createCard("Forest", "forest_6", "cards/land/forest.jpg"));
        dereviDeckTemp.add(createCard("Path to Exile", "pathToExile", "cards/white/instant/pathToExile.jpg"));
        dereviDeckTemp.add(createCard("Evacuation", "evacuation", "cards/blue/instant/evacuation.jpg"));
        dereviDeckTemp.add(createCard("Forest", "forest_7", "cards/land/forest.jpg"));
        dereviDeckTemp.add(createCard("Telling Time", "tellingTime", "cards/blue/instant/tellingTime.jpg"));
        dereviDeckTemp.add(createCard("Swords to Plowshares", "swordsToPlowshares", "cards/white/instant/swordsToPlowshares.jpg"));
        dereviDeckTemp.add(createCard("Thassa, God of the Sea", "thassaGodOfTheSea", "cards/blue/creature/thassaGodOfTheSea.jpg"));
        dereviDeckTemp.add(createCard("Rafiq of the Many", "rafiqOfTheMany", "cards/multi/creature/rafiqOfTheMany.jpg"));
        dereviDeckTemp.add(createCard("Geist of the Archives", "geistOfTheArchives", "cards/blue/creature/geistOfTheArchives.jpg"));
        dereviDeckTemp.add(createCard("Hero's Blade", "herosBlade", "cards/colorless/artifact/herosBlade.jpg"));
        dereviDeckTemp.add(createCard("Derevi, Empyrial Tactician", "c13_186", "cards/multi/creature/dereviEmpyrialTactician.jpg"));

        return dereviDeckTemp;

    }

    private Card createCard(String name, String id, String src)
    {
        return new Card(name, id, src);
    }
}
