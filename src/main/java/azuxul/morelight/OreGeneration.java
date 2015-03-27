package azuxul.morelight;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGeneration implements IWorldGenerator {
	
	private final int maxHauteur, minHauteur, nbre;
	private WorldGenMinable WorldGenOre = new WorldGenMinable(null, 0);
	
	public OreGeneration(Block ore, int minY, int maxY, int frequency, int quantity){
		WorldGenOre = new WorldGenMinable(ore.getDefaultState(), quantity);
		maxHauteur = maxY;
		minHauteur = minY;
		nbre = frequency;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for(int i = 0; i < nbre; i++){
			int x = (chunkX << 4) + random.nextInt(16);
            int y = random.nextInt(maxHauteur - minHauteur) + minHauteur;
            int z = (chunkZ << 4) + random.nextInt(16);
            WorldGenOre.generate(world, random, new BlockPos(x,y,z));
		}	}
	
}