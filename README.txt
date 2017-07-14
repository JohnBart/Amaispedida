# Amaispedida
Projeto de disciplina

Projeto tem por objetivo, utilizar elementos de programação da plataforma android para criar um APP  que ira utilizar SQL com
content provider para criar uma lista de musicas que ira compor o repertório de usuário músico, o usuário espectador poderá
consultar esta lista e realizar o pedido para que o musico toque esta musica. Ao realizar a solicitação, o músico deve ser notificado
do pedido.


O que já foi implementado:

ACTIVITYS

                                         solicitarMusicaActivity
                                       /
                EspectadorMainActivity
              /
LoginActivity                        CadastrarShowActivity - SelecionarRepertorioActivity
      |       \                    / 
      |        MusicoMainActivity  -- CadastrarMusicaRepertorioActivity
      |                            \
CadastroActivity                     ExecutarRepertorioActivity
                                     
 
 1) LoginActivity
     - Efetua o login do usuário, com base em username(email) e senha.
     - Se o usuário não possuir cadastro, chama a CadastroActivity para efetuar o cadastro.
     - Dependendo do perfil de quem está realizando o login, chama EspectadorMainActivity ou MusicoMainActivity.
 2) CadastroActivity
     - Usuário deve realizar cadastro fornecendo nome, e-mail e senha.
     - Deve selecionar atravez de um checkbox o tipo do perfil (musico ou espectador).
 3) EspectadorMainActivity
     - Abre uma lista de cards, com os shows cadastrados e demais informações
     - pode vizualizar o repertório do artista, podenso solicitar musicas dentro de uma lista pré cadastrada ou cadastrar uma musica nova.
  4) MusicoMainActivity
     - Possuí um menu de opção, onde pode optar por cadastrar um novo show, cadastrar as musicas do repertório e realizar o controle de musicas executadas/pedidas durante um show.
     
  5) CadastrarShowActivity
     - Realiza o cadastro de um novo show, inserindo data, hora e local, alem de poder selecionar dentro da lista de músicas cadastradas do usuário como as do repertório daquele show (via SelecionarRepertorioActivity).
     
  6) SelecionarRepertorioActivity
     - Seleciona dentro da lista de músicas cadastradas do usuário musico como as do repertório daquele show.
     
  7) CadastrarMusicaRepertorioActivity
     - Cadastra dentro de uma lista uma nova música dentro do repertório do artistas (músicas que ele sabe tocar).
     
  8) ExecutarRepertorioActivity
     - Acompanha a execução de um show pré cadastrado, o usuário musico visualiza as musicas cadastrada para tocar naquele show, podendo retirá -las após a execução, nesta tela tambem são exibidas as musicas solicitadas pelo usuário espectador.
     
     
ADAPTERS
  1) MusicaListViewAdapter
  2) EventoListViewAdapter
  
 Classes de suporte
 
 1)Evento: cria atributos para implementar a atividade evento. Utilizar Get and set para acessar e alterar as variaveis desta classe.
 2)Musica: Iden a 1.
 
 
 RES
 1) Colors: Contem a definição de cores do app, atentar para o uso correto seguindo padrão Matherial Design.








