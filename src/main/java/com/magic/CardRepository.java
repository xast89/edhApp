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
    private List<Card> xenagosDeck;

    public CardRepository()
    {
        this.dereviDeck = createDereviDeck();
        this.xenagosDeck = createXenagosDeck();

    }

    public List<Card> getDereviDeck()
    {
        return dereviDeck;
    }

    public List<Card> getXenagosDeck() { return xenagosDeck;}

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

    private List<Card> createXenagosDeck()
    {
        List<Card> xenagosDeckTemp = new ArrayList<>();

        xenagosDeckTemp.add(createCard("Forest", "forest", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_2", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_3", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_4", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_5", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_6", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_7", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_8", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_9", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_10", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_11", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_12", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_13", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_14", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Forest", "forest_15", "cards/land/forest.jpg"));
        xenagosDeckTemp.add(createCard("Mountain", "mountain", "cards/land/mountain.jpg"));
        xenagosDeckTemp.add(createCard("Mountain", "mountain_2", "cards/land/mountain.jpg"));
        xenagosDeckTemp.add(createCard("Mountain", "mountain_3", "cards/land/mountain.jpg"));
        xenagosDeckTemp.add(createCard("Mountain", "mountain_4", "cards/land/mountain.jpg"));
        xenagosDeckTemp.add(createCard("Mountain", "mountain_5", "cards/land/mountain.jpg"));
        xenagosDeckTemp.add(createCard("Mountain", "mountain_6", "cards/land/mountain.jpg"));
        xenagosDeckTemp.add(createCard("Mountain", "mountain_7", "cards/land/mountain.jpg"));
        xenagosDeckTemp.add(createCard("Mountain", "mountain_8", "cards/land/mountain.jpg"));
        xenagosDeckTemp.add(createCard("Mountain", "mountain_9", "cards/land/mountain.jpg"));
        xenagosDeckTemp.add(createCard("Mountain", "mountain_10", "cards/land/mountain.jpg"));
        xenagosDeckTemp.add(createCard("Mountain", "mountain_11", "cards/land/mountain.jpg"));
        xenagosDeckTemp.add(createCard("Mountain", "mountain_12", "cards/land/mountain.jpg"));
        xenagosDeckTemp.add(createCard("Nissa's Pilgrimage", "nissasPilgrimage", "cards/green/sorcery/nissasPilgrimage.jpg"));
        xenagosDeckTemp.add(createCard("Command Tower", "commandTower", "cards/land/commandTower.jpg"));
        xenagosDeckTemp.add(createCard("Titanic Growth", "titanicGrowth", "cards/green/instant/titanicGrowth.jpg"));
        xenagosDeckTemp.add(createCard("Fog", "fog", "cards/green/instant/fog.jpg"));
        xenagosDeckTemp.add(createCard("Ancient Grudge", "ancientGrudge", "cards/red/instant/ancientGrudge.jpg"));
        xenagosDeckTemp.add(createCard("Signal the Clans", "signalTheClans", "cards/multi/instant/signalTheClans.jpg"));
        xenagosDeckTemp.add(createCard("Berser", "berserk", "cards/green/instant/berserk.jpg"));
        xenagosDeckTemp.add(createCard("Beast Within", "beastWithin", "cards/green/instant/beastWithin.jpg"));
        xenagosDeckTemp.add(createCard("Invigorated Rampage", "invigoratedRampage", "cards/red/instant/invigoratedRampage.jpg"));
        xenagosDeckTemp.add(createCard("Heroic Intervention", "heroicIntervention", "cards/green/instant/heroicIntervention.jpg"));
        xenagosDeckTemp.add(createCard("Strionic Resonator", "strionicResonator", "cards/colorless/artifact/strionicResonator.jpg"));
        xenagosDeckTemp.add(createCard("Hammer of Purphoros", "hammerOfPurphoros", "cards/red/artifact/hammerOfPurphoros.jpg"));
        xenagosDeckTemp.add(createCard("Emerald Medallion", "emeraldMedallion", "cards/colorless/artifact/emeraldMedallion.jpg"));
        xenagosDeckTemp.add(createCard("Sol Ring", "solRing", "cards/colorless/artifact/solRing.jpg"));
        xenagosDeckTemp.add(createCard("Mage Slayer", "mageSlayer", "cards/multi/artifact/mageSlayer.jpg"));
        xenagosDeckTemp.add(createCard("Terastodon", "terastodon", "cards/green/creature/terastodon.jpg"));
        xenagosDeckTemp.add(createCard("Rampaging Baloths", "rampagingBaloths", "cards/green/creature/rampagingBaloths.jpg"));
        xenagosDeckTemp.add(createCard("Malignus", "malignus", "cards/red/creature/malignus.jpg"));
        xenagosDeckTemp.add(createCard("Realm Seekers", "realmSeekers", "cards/green/creature/realmSeekers.jpg"));
        xenagosDeckTemp.add(createCard("Spellbreaker Behemoth", "spellbreakerBehemoth", "cards/multi/creature/spellbreakerBehemoth.jpg"));
        xenagosDeckTemp.add(createCard("Nylea, God of the Hunt", "nyleaGodOfTheHunt", "cards/green/creature/nyleaGodOfTheHunt.jpg"));
        xenagosDeckTemp.add(createCard("Caller of the Pack", "callerOfThePack", "cards/green/creature/callerOfThePack.jpg"));
        xenagosDeckTemp.add(createCard("Thunderfoot Baloth", "thunderfootBaloth", "cards/green/creature/thunderfootBaloth.jpg"));
        xenagosDeckTemp.add(createCard("Sakura-Tribe Elder", "sakura-TribeElder", "cards/green/creature/sakura-TribeElder.jpg"));
        xenagosDeckTemp.add(createCard("Oracle of Mul Daya", "oracleOfMulDaya", "cards/green/creature/oracleOfMulDaya.jpg"));
        xenagosDeckTemp.add(createCard("Selvala, Heart of the Wilds", "selvalaHeartOfTheWilds", "cards/green/creature/selvalaHeartOfTheWilds.jpg"));
        xenagosDeckTemp.add(createCard("Inferno Titan", "infernoTitan", "cards/red/creature/infernoTitan.jpg"));
        xenagosDeckTemp.add(createCard("Deus of Calamity", "deusOfCalamity", "cards/multi/creature/deusOfCalamity.jpg"));
        xenagosDeckTemp.add(createCard("Hydra Omnivore", "hydraOmnivore", "cards/green/creature/hydraOmnivore.jpg"));
        xenagosDeckTemp.add(createCard("Pathbreaker Ibex", "pathbreakerIbex", "cards/green/creature/pathbreakerIbex.jpg"));
        xenagosDeckTemp.add(createCard("Reclamation Sage", "reclamationSage", "cards/green/creature/reclamationSage.jpg"));
        xenagosDeckTemp.add(createCard("Dragonlord Atarka", "dragonlordAtarka", "cards/multi/creature/dragonlordAtarka.jpg"));
        xenagosDeckTemp.add(createCard("Ruric Thar, the Unbowed", "ruricThartheUnbowed", "cards/multi/creature/ruricThartheUnbowed.jpg"));
        xenagosDeckTemp.add(createCard("Zendikar Incarnate", "zendikarIncarnate", "cards/multi/creature/zendikarIncarnate.jpg"));
        xenagosDeckTemp.add(createCard("Mina and Denn, Wildborn", "minaAndDennWildborn", "cards/multi/creature/minaAndDennWildborn.jpg"));
        xenagosDeckTemp.add(createCard("Radha, Heir to Keld", "radhaHeirToKeld", "cards/multi/creature/radhaHeirToKeld.jpg"));
        xenagosDeckTemp.add(createCard("Grull Ragebeast", "grullRagebeast", "cards/multi/creature/grullRagebeast.jpg"));
        xenagosDeckTemp.add(createCard("Soulbright Flamekin", "soulbrightFlamekin", "cards/red/creature/soulbrightFlamekin.jpg"));
        xenagosDeckTemp.add(createCard("Burnished Hart", "burnishedHart", "cards/colorless/creature/burnishedHart.jpg"));
        xenagosDeckTemp.add(createCard("Soul of  The Harvest", "soulOfTheHarvest", "cards/green/creature/soulOfTheHarvest.jpg"));
        xenagosDeckTemp.add(createCard("Siege Behemoth", "siegeBehemoth", "cards/green/creature/siegeBehemoth.jpg"));
        xenagosDeckTemp.add(createCard("Birds Of Paradise", "birdsOfParadise", "cards/green/creature/birdsOfParadise.jpg"));
        xenagosDeckTemp.add(createCard("Llanowar Elves", "llanowarElves", "cards/green/creature/llanowarElves.jpg"));
        xenagosDeckTemp.add(createCard("Wood Elves", "woodElves", "cards/green/creature/woodElves.jpg"));
        xenagosDeckTemp.add(createCard("Harmonize", "harmonize", "cards/green/sorcery/harmonize.jpg"));
        xenagosDeckTemp.add(createCard("Overwhelming Stampede", "overwhelmingStampede", "cards/green/sorcery/overwhelmingStampede.jpg"));
        xenagosDeckTemp.add(createCard("Green Sun's Zenith", "greenSunsZenith", "cards/green/sorcery/greenSunsZenith.jpg"));
        xenagosDeckTemp.add(createCard("Eldritch Evolution", "eldritchEvolution", "cards/green/sorcery/eldritchEvolution.jpg"));
        xenagosDeckTemp.add(createCard("Cultivate", "cultivate", "cards/green/sorcery/cultivate.jpg"));
        xenagosDeckTemp.add(createCard("Hunter's Prowess", "huntersProwess", "cards/green/sorcery/huntersProwess.jpg"));
        xenagosDeckTemp.add(createCard("Life's Legacy", "lifesLegacy", "cards/green/sorcery/lifesLegacy.jpg"));
        xenagosDeckTemp.add(createCard("Selvala's Stampede", "selvalasStampede", "cards/green/sorcery/selvalasStampede.jpg"));
        xenagosDeckTemp.add(createCard("Selvala's Stampede", "selvalasStampede", "cards/green/sorcery/selvalasStampede.jpg"));
        xenagosDeckTemp.add(createCard("Explosive Vegetation", "explosiveVegetation", "cards/green/sorcery/explosiveVegetation.jpg"));
        xenagosDeckTemp.add(createCard("See the Unwritten", "seetheUnwritten", "cards/green/sorcery/seetheUnwritten.jpg"));
        xenagosDeckTemp.add(createCard("Praetor's Counsel", "praetorsCounsel", "cards/green/sorcery/praetorsCounsel.jpg"));
        xenagosDeckTemp.add(createCard("Chandra's Ignition", "chandrasIgnition", "cards/red/sorcery/chandrasIgnition.jpg"));
        xenagosDeckTemp.add(createCard("Seize The Day", "seizeTheDay", "cards/red/sorcery/seizeTheDay.jpg"));
        xenagosDeckTemp.add(createCard("Decimate", "decimate", "cards/multi/sorcery/decimate.jpg"));
        xenagosDeckTemp.add(createCard("Rugged Highlands", "ruggedHighlands", "cards/land/ruggedHighlands.jpg"));
        xenagosDeckTemp.add(createCard("Reliquary Tower", "reliquaryTower", "cards/land/reliquaryTower.jpg"));
        xenagosDeckTemp.add(createCard("Kazandu Refuge", "kazanduRefuge", "cards/land/kazanduRefuge.jpg"));
        xenagosDeckTemp.add(createCard("Rogue's Passage", "roguesPassage", "cards/land/roguesPassage.jpg"));
        xenagosDeckTemp.add(createCard("Blighted Woodland", "blightedWoodland", "cards/land/blightedWoodland.jpg"));
        xenagosDeckTemp.add(createCard("Timber Gorge", "timberGorge", "cards/land/timberGorge.jpg"));
        xenagosDeckTemp.add(createCard("Skarrg, the Rage Pits", "skarrgTheRagePits", "cards/land/skarrgTheRagePits.jpg"));
        xenagosDeckTemp.add(createCard("Cinder Glade", "cinderGlade", "cards/land/cinderGlade.jpg"));
        xenagosDeckTemp.add(createCard("Evolutionary Leap", "evolutionaryLeap", "cards/green/enchantment/evolutionaryLeap.jpg"));
        xenagosDeckTemp.add(createCard("Blood Mist", "bloodMist", "cards/red/enchantment/bloodMist.jpg"));
        xenagosDeckTemp.add(createCard("Berserker's Onslaught", "berserkersOnslaught", "cards/red/enchantment/berserkersOnslaught.jpg"));
        xenagosDeckTemp.add(createCard("Abundance", "abundance", "cards/green/enchantment/abundance.jpg"));
        xenagosDeckTemp.add(createCard("Archetype of Aggression", "archetypeOfAggression", "cards/red/creature/archetypeOfAggression.jpg"));
        xenagosDeckTemp.add(createCard("Garruk, Caller  of Beasts", "garrukCallerofBeasts", "cards/green/planeswalker/garrukCallerofBeasts.jpg"));
        xenagosDeckTemp.add(createCard("Xenagos, God of Revels", "xenagosGodOfRevels", "cards/multi/creature/xenagosGodOfRevels.jpg"));

        return xenagosDeckTemp;
    }

    private Card createCard(String name, String id, String src)
    {
        return new Card(name, id, src);
    }
}
