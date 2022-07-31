### Especificações
Neste sistema, somente as rotas de leitura (GET) de eventos e cidades são públicas (não precisa de login). Usuários CLIENT podem também inserir (POST) novos eventos. Os demais acessos são permitidos apenas a usuários ADMIN.
Caso tenha dúvidas nas regras de autorização do ResourceServerConfig, colocamos uma sugestão em linguagem natural na próxima página.

#### Validações de City:
Nome não pode ser vazio

#### Validações de Event:
Nome não pode ser vazio
Data não pode ser passada
Cidade não pode ser nula

Mínimo para aprovação: 9/12
