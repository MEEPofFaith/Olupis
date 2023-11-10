package olupis.content;

import arc.func.Cons;
import mindustry.content.Items;
import mindustry.game.Rules;
import mindustry.type.ItemStack;
import mindustry.type.SectorPreset;

import static olupis.content.NyfalisPlanets.*;

public class NyfalisSectors {

    public  static SectorPreset
        /*Arthin*/
        sanctuary, vakinyaDesert, muddyRivers, mossyRavine, gardeniorTemple,
        /*Nyfalis*/
        placeholder2,
        /*Spelta*/
         dormantCell, forestOfHope
    ;

    public static void LoadSectors(){
        //region Seredris
        sanctuary = new SectorPreset("sanctuary", arthin, 2){{
            alwaysUnlocked = overrideLaunchDefaults = true;
            addStartingItems = false;

            captureWave = 15;
            difficulty = 1;
            rules = commonRules(captureWave, false);
        }};

        mossyRavine = new SectorPreset("mossy-ravine", arthin, 31){{
            addStartingItems = allowLaunchLoadout = allowLaunchSchematics = false;

            captureWave = 33;
            difficulty = 2;
            rules = commonRules(captureWave, false);
        }};

        muddyRivers = new SectorPreset("muddy-rivers", arthin, 21){{
            addStartingItems = true;
            allowLaunchLoadout = allowLaunchSchematics = false;

            captureWave = 38;
            rules = commonRules(captureWave, false);
            difficulty = 2;
        }};

        vakinyaDesert = new SectorPreset("vakinya-desert", arthin, 10){{
            addStartingItems = allowLaunchLoadout = allowLaunchSchematics = false;

            captureWave = 17;
            difficulty = 2;
            rules = commonRules(captureWave, 22.32f);
        }};

        gardeniorTemple = new SectorPreset("gardenior-temple", arthin, 7){{
            addStartingItems = true;
            allowLaunchLoadout = allowLaunchSchematics = false;

            difficulty = 3;
            captureWave = 26;
            rules = commonRules(captureWave, false);
        }};

        //endregion
        //region Nyfalis

        placeholder2 = new SectorPreset("placeholder2", nyfalis, 69){{
            captureWave = 20;
            difficulty = 3;
            rules = commonRules(captureWave);
        }};

        //endregion
        //region Vorgin
        dormantCell = new SectorPreset("dorment-cell", spelta, 1){{
            /*Yes this map's lore may or may not be a reference to command and conquer*/
            difficulty = 4;
            rules = commonRules(captureWave);
        }};

        forestOfHope = new SectorPreset("forest-of-hope", spelta,  4){{
            difficulty = 2;
            rules = commonRules(captureWave);
        }};
    }

    //moved it here, so players switching planets rule isn't affected & per map dropZonesRadius are possible
    public static void defaultRules(Rules r, boolean startItems, float dzRadius){
        if(dzRadius <= 0)r.dropZoneRadius = 400f;
        else r.dropZoneRadius = dzRadius;
        r.enemyCoreBuildRadius = 650f;

        NyfalisBlocks.nyfalisBuildBlockSet.each(b -> r.bannedBlocks.add(b));
        NyfalisBlocks.sandBoxBlocks.each(b -> r.bannedBlocks.add(b));
        if(startItems)r.loadout.clear().add(new ItemStack(NyfalisItemsLiquid.rustyIron, 100), new ItemStack(Items.lead, 100));
    }

    public static void defaultRules(Rules r){
        defaultRules(r, true,-1f);
    }
    public static void defaultRules(Rules r, float dzRadius){
        defaultRules(r, true, dzRadius);
    }

    public static Cons<Rules> commonRules(int captureWave, boolean startItems, float dzRadius){ return r ->{
        r.winWave = captureWave;
        defaultRules(r, startItems, dzRadius);
    };}

    public static Cons<Rules> commonRules(int captureWave, boolean startItems){
        return commonRules(captureWave, startItems, -1f);
    }

    public static Cons<Rules> commonRules(int captureWave){
        return commonRules(captureWave, true, -1f);
    }
    public static Cons<Rules> commonRules(int captureWave, float dzRadius){
        return commonRules(captureWave, true, dzRadius);
    }

}
