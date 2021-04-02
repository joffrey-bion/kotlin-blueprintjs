@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

@file:JsModule("@blueprintjs/core")
package com.palantir.blueprintjs.core

import React.HTMLAttributes
import kotlin.js.*
import org.w3c.dom.*
import global.JSX.Element
import react.ReactElement

external interface IButtonProps : IActionProps, IElementRefProps<HTMLElement> {
    var active: Boolean?
    var alignText: Any?
    var fill: Boolean?
    var large: Boolean?
    var loading: Boolean?
    var minimal: Boolean?
    var outlined: Boolean?
    var rightIcon: dynamic /* Any | JSX.Element? | Boolean? */
    var small: Boolean?
    var type: String? /* "submit" | "reset" | "button" */
}

external interface IButtonState {
    var isActive: Boolean
}

//external open class AbstractButton<H>(
//    props: H,
//    context: Any = definedExternally
//): AbstractPureComponent2__2<H, IButtonState>  where H : HTMLAttributes<out HTMLElement>, H : IButtonProps {
//    override fun render(): Element
//    open fun getCommonButtonProps(): ICommonButtonProps
//}

//external interface ICommonButtonProps {
//    var className: String
//    var disabled: dynamic /* Any | Any */
//    var onBlur: (e: FocusEvent<Any>) -> Unit
//    var onClick: Any
//    var onKeyDown: (e: KeyboardEvent<Any>) -> Unit
//    var onKeyUp: (e: KeyboardEvent<Any>) -> Unit
//    var tabIndex: dynamic /* Number? | Any */
//}
//
//external interface IButtonPropsAndAttributes : IButtonProps, ButtonHTMLAttributes<HTMLButtonElement> {
//    override var type: String?
//    override var onClick: MouseEventHandler<HTMLButtonElement>?
//}
//
//external open class Button(
//    props: IButtonProps /* IButtonProps & ButtonHTMLAttributes<HTMLButtonElement> */,
//    context: Any = definedExternally
//): AbstractButton<IButtonPropsAndAttributes /* IButtonProps & ButtonHTMLAttributes<HTMLButtonElement> */> {
//    override fun render(): Element
//}
//
//external open class AnchorButton(
//    props: AnchorHTMLAttributes<HTMLAnchorElement>,
//    context: Any = definedExternally
//): AbstractButton<AnchorHTMLAttributes<HTMLAnchorElement>> {
//    override fun render(): Element
//}