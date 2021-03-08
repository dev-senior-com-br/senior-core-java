# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added

-   Incluidas as primitivas `getCustomProperty`, `createCustomProperty`, `updateCustomProperty` e `deleteCustomProperty` do serviço Configuration

### Changed

-   Transformando as classes de testes unitários em classes de exemplos.

## [1.2.0] - 2021-02-03

### Changed

-   Alterado os endpoints do `User.deleteGroup` e `User.deleteUser`. Agora passam a chamar o serviço de `user` (`user\actions\deleteUser` e `user\actions\removeGroup`).

## [1.1.0] - 2020-08-31

### Changed

-   Melhorias na classe `NotificationIT`

## [1.0.0] - 2020-08-25

### Added

-   Criado classe `BlobClient` para realizar as chamadas para o serviço de manipulação de arquivos(`BlobService`)

### Changed

-   Refatorado testes de exemplo da classe `UserIT`

### Removed

-   Removido campo email da classe `GetUserInput`

### Fixed

-   Correção da URL quando a busca de entidades contém filtros

## [0.23.1] - 2020-08-18

### Added

### Changed

### Fixed

### Removed

[Unreleased]: https://github.com/dev-senior-com-br/senior-core-java/compare/v1.2.0...HEAD

[1.2.0]: https://github.com/dev-senior-com-br/senior-core-java/compare/v1.1.0...1.2.0

[1.1.0]: https://github.com/dev-senior-com-br/senior-core-java/compare/v1.0.0...1.1.0

[1.0.0]: https://github.com/dev-senior-com-br/senior-core-java/compare/v0.23.1...1.0.0

[0.23.1]: https://github.com/dev-senior-com-br/senior-core-java/compare/v0.1.0...0.23.1
