import org.jetbrains.kotlin.backend.common.IrElementTransformerVoidWithContext
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.declarations.IrFunction
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.expressions.IrCall
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.impl.IrConstImpl
import org.jetbrains.kotlin.ir.visitors.transformChildrenVoid
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.name.SpecialNames
import org.jetbrains.kotlin.utils.addToStdlib.cast

class MySamplePluginIrExtension : IrGenerationExtension {
  override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {
    moduleFragment.transformChildrenVoid(CurrentFunctionNameTransformer())
  }
}

private class CurrentFunctionNameTransformer : IrElementTransformerVoidWithContext() {
  override fun visitCall(expression: IrCall): IrExpression {
    if (expression.symbol.owner.name == CURRENT_FUNCTION_NAME_NAME)
      return IrConstImpl.string(
        startOffset = expression.startOffset,
        endOffset = expression.endOffset,
        type = expression.symbol.owner.returnType,
        value = currentFunction?.irElement?.cast<IrFunction>()?.name?.asString() ?: SpecialNames.ANONYMOUS_STRING,
      )

    return super.visitCall(expression)
  }

  companion object {
    private val CURRENT_FUNCTION_NAME_NAME = Name.identifier("currentFunctionName")
  }
}
