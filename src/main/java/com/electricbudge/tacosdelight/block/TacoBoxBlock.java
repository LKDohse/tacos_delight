package com.electricbudge.tacosdelight.block;

import com.electricbudge.tacosdelight.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
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

import static com.electricbudge.tacosdelight.registry.ModItems.getTaco;

public class TacoBoxBlock extends FeastBlock {
    public static final IntegerProperty TACO_SERVINGS = IntegerProperty.create("servings", 0, 6);

    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape FOOD_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(2.0D, 2.0D, 2.0D, 14.0D, 4.0D, 14.0D), BooleanOp.OR);

    private ModItems.FillingType fillingType;

    public TacoBoxBlock(Properties properties, ModItems.FillingType constructorFillingType) {
        super(properties, getTaco(constructorFillingType), true);
        this.fillingType = constructorFillingType;
        tacoBoxServings = Arrays.asList(
                getTaco((fillingType)),
                getTaco((fillingType)),
                getTaco((fillingType)),
                getTaco((fillingType)),
                getTaco((fillingType)),
                getTaco((fillingType))
        );
    }

    public List<Supplier<Item>> tacoBoxServings;

    @Override
    public IntegerProperty getServingsProperty() {
        return TACO_SERVINGS;
    }

    @Override
    public int getMaxServings() {
        return 6;
    }

    @Override
    public ItemStack getServingItem(BlockState state) {
        return new ItemStack(tacoBoxServings.get(state.getValue(getServingsProperty()) - 1).get());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(getServingsProperty()) == 0 ? PLATE_SHAPE : FOOD_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TACO_SERVINGS);
    }
}
