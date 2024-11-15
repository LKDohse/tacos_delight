package com.electricbudge.tacosdelight.block;

import com.electricbudge.tacosdelight.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static com.electricbudge.tacosdelight.registry.ModItems.*;

public class CravingsBoxBlock extends FeastBlock {
    public static final IntegerProperty FOOD_SERVINGS = IntegerProperty.create("servings", 0, 8);

    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape FOOD_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(2.0D, 2.0D, 2.0D, 14.0D, 4.0D, 14.0D), BooleanOp.OR);

    private ModItems.FillingType fillingType;

    public CravingsBoxBlock(BlockBehaviour.Properties properties, ModItems.FillingType fillingType){
        super(properties, ModItems.getCrunchwrap(fillingType), true);
        this.fillingType = fillingType;
        cravingsBoxServings = Arrays.asList(
                getQuesadilla((this.fillingType)),
                getTaco((this.fillingType)),
                getBurrito((this.fillingType)),
                getCrunchwrap((this.fillingType)),
                getTaco((this.fillingType)),
                getQuesadilla((this.fillingType)),
                getBurrito((this.fillingType)),
                getCrunchwrap((this.fillingType))
        );
    }

    public List<Supplier<Item>> cravingsBoxServings;

    @Override
    public IntegerProperty getServingsProperty() {
        return FOOD_SERVINGS;
    }

    @Override
    public int getMaxServings() {
        return 8;
    }

    @Override
    public ItemStack getServingItem(BlockState state) {
        return new ItemStack(cravingsBoxServings.get(state.getValue(getServingsProperty()) - 1).get());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(getServingsProperty()) == 0 ? PLATE_SHAPE : FOOD_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, FOOD_SERVINGS);
    }
}
