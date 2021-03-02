package littlebreadloaf.bleachreborn.render.entity;

import cpw.mods.fml.client.registry.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.entities.*;
import littlebreadloaf.bleachreborn.render.models.*;

public class Renders
{
    public static void renderEntities() {
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityWhole.class, (Render)new RenderWhole(new ModelBiped(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityHollowBat.class, (Render)new RenderHollowBat(new ModelHollowBat(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityHollowBlaze.class, (Render)new RenderHollowBlaze(new ModelHollowBlaze(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityHollowSpider.class, (Render)new RenderHollowSpider(new ModelHollowSpider(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityHollowGolem.class, (Render)new RenderHollowGolem(new ModelHollowGolem(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityHollowSnake.class, (Render)new RenderHollowSnake(new ModelHollowSnake(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityHollowWasp.class, (Render)new RenderHollowWasp(new ModelHollowWasp(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityHollowStalker.class, (Render)new RenderHollowStalker(new ModelHollowStalker(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityHollowWolf.class, (Render)new RenderHollowWolf(new ModelHollowWolf(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityHollowOre.class, (Render)new RenderHollowOre(new ModelHollowOre(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntitySmallHollowLizard.class, (Render)new RenderSmallHollowLizard(new ModelSmallHollowLizard(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityMenosGrande.class, (Render)new RenderMenosGrande(new ModelMenosGrande(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityFisher.class, (Render)new RenderFisher(new ModelFisher(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityDecoy.class, (Render)new RenderDecoy(new ModelBiped(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityShinigami.class, (Render)new RenderShinigami(new ModelBiped(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityInnerSpirit.class, (Render)new RenderInnerSpirit(new ModelBiped(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityGrimmjow.class, (Render)new RenderGrimmjow(new ModelBiped(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityAizen.class, (Render)new RenderAizen(new ModelBiped(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler(EntityGigai.class, new RenderGigai(new ModelBiped(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler(EntityGigaiWeak.class, new RenderGigaiWeak(new ModelBiped(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityAshido.class, (Render)new RenderAshido(new ModelAshido(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityChad.class, (Render)new RenderChad(new ModelBiped(), 0.3f));
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityOrihime.class, (Render)new RenderOrihime(new ModelBiped(), 0.3f));
    }
}
