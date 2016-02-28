package fr.azuxul.morelight;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class OreGeneration implements IWorldGenerator {

    private final int maxHauteur, minHauteur, nbre;
    private WorldGenMinable worldGenOre = new WorldGenMinable(null, 0);

    public OreGeneration(Block ore) {
        worldGenOre = new WorldGenMinable(ore.getDefaultState(), 9);
        maxHauteur = 50;
        minHauteur = 2;
        nbre = 4;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        for (int i = 0; i < nbre; i++) {
            int x = (chunkX << 4) + random.nextInt(16);
            int y = random.nextInt(maxHauteur - minHauteur) + minHauteur;
            int z = (chunkZ << 4) + random.nextInt(16);
            worldGenOre.generate(world, random, new BlockPos(x, y, z));
        }
    }

}