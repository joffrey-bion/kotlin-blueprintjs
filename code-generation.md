# Kotlin externals generation

This document explains how to re-generate the external declarations when the version of BlueprintJS is upgraded.

## Prerequisites

Make sure Dukat is installed first:
```
npm install -g dukat
```

## Automated generation

Generate externals:
```
./gradlew generateBlueprintJSCore
```

This custom Gradle task does the following things:

1. go to the module of your choice (in `build/js/node_modules`)
2. find where the TypeScript index is by reading the package.json (which in the case of `@blueprintjs/core` yields `lib/esm/index.d.ts`)
3. Run dukat on this TypeScript file, specifying the chosen output folder (by default `src/main/generated`, but it should also be nested under a folder that matches the package - TODO)
4. Perform search&replace on the contents of the generated Kotlin files to fix some of Dukat's mistakes

## Manual fixes for Dukat's output

Keeping track of the compile errors and their (still manual) fixes.

**These fixes should be automated in step 4 of the gradle task as much as possible.**

| Problem | Manual fix |
|---------|------------|
| Type argument is not within its bounds: should be subtype of `HTMLAttributes<HTMLElement>` | Delete `AbstractButton` class (see below) |
| Class X must override *some property* because it inherits multiple interface methods of it | Add override manually in `IControlProps`, `IFileInputProps`, `ITextAreaProps` |
| Only nullable properties of external interfaces are allowed to be non-abstract | Make it nullable in `popover` and `popoverSharedProps` |
| X hides member of supertype Y and needs 'override' modifier | Add 3 override modifiers in `IPopoverSharedProps` |
| ... | ... |
| (this list is still incomplete) | ... |

### Reworking AbstractButton

The type of the props in `AbstractButton` needs to be both a subtype of `IButtonProps` and a subtype of some
`HTMLAttributes` class.
For this, we should use a plain type parameter with a `where` clause instead of a bounded type parameter
(otherwise we can't express both upper bounds).

Also, `HTMLAttributes<HTMLElement>` is not sufficient, and we should make it `HTMLAttributes<out HTMLElement>` so that
button subclasses can provide subclasses of `HTMLElement` as type parameter of `HTMLAttributes<T>`.
