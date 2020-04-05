## Modules

#### `:core`
- pure infrastructure
- no domain knowledge
- can be open source-able?
- lean -> no deprecated code

#### `:library-modules`
- no launchable features
- provides consumable interface via an interface

#### `:feature-module`
- single, addressable entry-point
- can **not** depend on other feature modules

#### `:app`
- **no feature**-specific code
- **no infrastructure** code
- creates dagger component


## TODO
- dynamic modules