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
  4) 
ADAPTERS





CLASSES DE ATRIBUTOS COM GETTERS E SETTERS





