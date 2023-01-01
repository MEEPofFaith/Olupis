package com.jirocab.planets.content;

import arc.Core;
import arc.graphics.Color;
import com.jirocab.planets.world.planets.*;
import mindustry.content.Planets;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.*;
import mindustry.type.Planet;
import mindustry.world.meta.Env;

public class OlupisPlanets {
    public  static Planet olupis, arthin, spelta;

    public  static void LoadPlanets(){
        olupis = new Planet("olupis", Planets.sun, 1f, 3){{
            generator = new OlupisPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 7);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(Color.valueOf("cee9f2")).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                    new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.white.cpy().lerp(Color.valueOf("cee9f2"), 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
            );
            defaultCore = OlupisBlocks.coreRemnant;
            unlockedOnLand.add(OlupisBlocks.coreRemnant);
            defaultEnv = Env.terrestrial | Env.oxygen;
            launchCapacityMultiplier = 0.4f;
            sectorSeed = 2;
            allowWaves = true;
            allowWaveSimulation = false;
            allowSectorInvasion = false;
            allowLaunchSchematics = false;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            //doesn't play well with configs
            prebuildBase = true;
            ruleSetter = r -> {
                r.waveTeam = Team.green;
                r.placeRangeCheck = false;
                r.attributes.clear();
                r.showSpawns = true;
                r.unitPayloadUpdate = true;
                r.enemyCoreBuildRadius = 650f;
                r.coreDestroyClear = true;
                r.dropZoneRadius = 400f;
                r.disableOutsideArea = false;
                //r.infiniteResources = true; //testing only
                //r.env = this.defaultEnv;
            };
            atmosphereColor = Color.valueOf("87CEEB");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.22f;
            startSector = 1;
            alwaysUnlocked = true;
            landCloudColor = Pal.engine.cpy().a(0.5f);
            hiddenItems.addAll(OlupisItemsLiquid.nonOlupisItems).removeAll(OlupisItemsLiquid.olupisOnlyItems);
        }};

        //1st moon
        arthin = new Planet("arthin", OlupisPlanets.olupis, 0.9f, 2){{
            generator = new ArthinPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
            defaultCore = OlupisBlocks.coreRemnant;
            alwaysUnlocked = true;
            defaultEnv = olupis.defaultEnv;
            clearSectorOnLose = true;
            iconColor = Color.valueOf("61615B");
            icon = "effect";
            allowSectorInvasion = true;
            hiddenItems.addAll(OlupisItemsLiquid.nonOlupisItems).removeAll(OlupisItemsLiquid.olupisOnlyItems);
            enemyBuildSpeedMultiplier = 0.4f;
            accessible = false;

            //TODO SHOULD there be lighting?
            updateLighting = true;

            ruleSetter = r -> {
                r.waveTeam = Team.green;
                r.placeRangeCheck = false;
                r.attributes.clear();
                r.showSpawns = true;
                r.unitPayloadUpdate = true;
                r.enemyCoreBuildRadius = 650f;
                r.coreDestroyClear = true;
                r.dropZoneRadius = 400f;
                r.disableOutsideArea = false;
            };
        }};

        spelta = new Planet("spelta", OlupisPlanets.olupis, 0.9f, 2){{
            generator = new SpeltaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
            defaultCore = OlupisBlocks.coreRemnant;
            alwaysUnlocked = true;
            defaultEnv = olupis.defaultEnv;
            clearSectorOnLose = true;
            iconColor = Color.valueOf("61615B");
            icon = "effect";
            allowSectorInvasion = true;
            hiddenItems.addAll(OlupisItemsLiquid.nonOlupisItems).removeAll(OlupisItemsLiquid.olupisOnlyItems);
            enemyBuildSpeedMultiplier = 0.4f;
            accessible = false;

            //TODO SHOULD there be lighting?
            updateLighting = true;

            ruleSetter = r -> {
                r.waveTeam = Team.green;
                r.placeRangeCheck = false;
                r.attributes.clear();
                r.showSpawns = true;
                r.unitPayloadUpdate = true;
                r.enemyCoreBuildRadius = 650f;
                r.coreDestroyClear = true;
                r.dropZoneRadius = 400f;
                r.disableOutsideArea = false;
            };
        }};
    }
}
