# Erudio Client Android

Este é um cliente [REST](https://en.wikipedia.org/wiki/Representational_state_transfer), desenvolvido em ANDROID, que se comunica com a aplicação [Erudio Cliente WS Exporter](https://github.com/leandrocgsi/erudio-client-ws-exporter) servidor via [HTTP](https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol) consumindo os web-services disponibilizados pelo segundo. O [Erudio Cliente WS Exporter](https://github.com/leandrocgsi/erudio-client-ws-exporter) por sua vez é uma aplicação "proxy" que se comunica com o server [Erudio](https://github.com/leandrocgsi/erudio) via [RMI](https://pt.wikipedia.org/wiki/RMI) e expõe serviços [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) via [HTTP](https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol).


O “Erudio Android Client”
	
	Como já foi dito existe a possibilidade de se construir componentes que se comuniquem com a aplicação servidora em diversas plataformas através da comunicação com web-services REST. O nosso cliente de exemplo foi desenvolvido na plataforma Android, mas podemos aplicar os conceitos básicos deste em praticamente qualquer plataforma. Isto é válido para, IOS, BlackBarry, Windows Phone, Delphi, .NET, Ruby etc. Tudo isto demonstra o potencial de extensibilidade da aplicação.
	A figura acima representa a arquitetura do cliente Android. Ele se comunica com WS-Exporter Client através de web-services. Conforme podemos observar na figura acima, a estrutura de pacotes se divide em:
•	br.com.Erudio.clientcontrol.android   nesse pacote estão as activities da aplicação. Ao abrir a aplicação a LoginActivity é inicializada, ela é responsável por autenticar o usuário no WS-Exporter e armazenar suas credenciais no bean Authentication do pacote correspondente. Isto é necessário por que a cada requisição as credenciais devem ser enviadas ao WS-Exporter, que, como já foi dito, não cria sessão de usuário. Se o login for bem sucedido o usuário é redirecionado para o menu da aplicação;
•	br.com.Erudio.clientcontrol.android.authentication   nesse pacote temos apenas duas classes uma é um singleton responsável por armazenar as credenciais do usuário e a segunda é responsável por setar as credenciais do usuário durante a execução dos métodos GET, POST e PUT;
•	br.com.Erudio.clientcontrol.android.communication   este pacote armazena a classe responsável por efetuar a comunicação com o WS-Exporter;
•	br.com.Erudio.clientcontrol.android.util   esse pacote armazena as classes utilitárias da aplicação por hora tem-se apenas o conversor para  SHA1;
•	br.com.Erudio.clientcontrol.android.util.baseurl   esse pacote tem apenas uma classe que armazena as constantes das URL nas quais a aplicação se conecta;
•	br.com.Erudio.clientcontrol.android.util.http   esse pacote armazena a classe utilitária HttpUtil que é responsável por executar os métodos GET, POST e PUT, além disso recupera o status da response e converte JSON em JSONObject ou JSONArray.

 

	
	Além desses conceitos básicos o desenvolvedor precisará apenas conhecer conceitos básicos de Android e de JSON para desenvolver um cliente baseado nessa arquitetura. Vale destacar também que outros clientes em outras linguagens podem ser desenvolvidos levando em conta estes mesmos conceitos, o que muda, é que provavelmente já devem haver bibliotecas nativas que facilitem o processo de conversão de JSON em Objeto e vice versa.

