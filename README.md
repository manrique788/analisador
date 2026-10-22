# Analisador R — protótipo Android

Projeto inicial de aplicativo nativo Android com interface escura e verde neon.

**Estado honesto:** este é apenas um protótipo de interface. Não captura a tela, não reconhece resultados reais e não calcula estatísticas reais ainda. O APK gerado pelo fluxo online, se a compilação passar, será somente uma versão de demonstração da interface.

## Gerar APK pelo GitHub Actions usando o celular

1. Entre em https://github.com/new pelo Android.
2. Nome sugerido: `AnalisadorR`. Marque **Public** ou **Private** como preferir e crie o repositório vazio. Não marque para adicionar README, licença ou `.gitignore`.
3. Abra o repositório e escolha **Add file → Upload files**. Extraia este ZIP antes de enviar; envie o conteúdo de dentro da pasta `AnalisadorR` (incluindo `.github`, `app`, `build.gradle`, `settings.gradle` e os demais arquivos) para a raiz do repositório. Em celulares, talvez seja necessário usar a opção “Versão para computador” do navegador.
4. Toque em **Commit changes**.
5. Abra a aba **Actions** do repositório. O workflow **Compilar APK Android** deve iniciar após o envio. Se não iniciar, abra o workflow e toque em **Run workflow**.
6. Aguarde o job terminar. Só considere compilado se aparecer um visto verde de sucesso.
7. Abra a execução concluída, vá até **Artifacts** e baixe `AnalisadorR-debug-apk`. Extraia o ZIP baixado para encontrar `app-debug.apk`.
8. Abra o APK no celular e, se o Android pedir, autorize a instalação pelo navegador/gerenciador de arquivos. Instale apenas o APK obtido do seu próprio repositório.

## Requisitos e limites

- O workflow usa Java 17, Android SDK e Gradle 8.9 para tentar compilar o APK de demonstração.
- Não há ainda permissão MediaProjection, serviço de captura, OCR, validação dos últimos 500 resultados, deduplicação ou monitoramento contínuo implementados.
- A leitura real da FBbet7 precisará ser desenvolvida e testada separadamente. A frequência observada não prevê nem garante o próximo resultado.
