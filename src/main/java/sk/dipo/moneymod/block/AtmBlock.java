package sk.dipo.moneymod.block;

import com.sun.istack.internal.NotNull;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

import javax.annotation.ParametersAreNonnullByDefault;

public class AtmBlock extends HorizontalBlock {

    public AtmBlock(Properties properties) {
        super(properties);
        super.setDefaultState(this.getDefaultState()
                .with(HORIZONTAL_FACING, Direction.NORTH)
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(HORIZONTAL_FACING);
    }
}
