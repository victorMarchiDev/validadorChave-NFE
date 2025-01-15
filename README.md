# API de Validação de Chaves de Notas Fiscais Eletrônicas

Esta API construida em Java e Spring, foi desenvolvida para validar chaves de acesso de notas fiscais eletrônicas (NF-e), extrair informações detalhadas da chave e fornecer o link oficial para consulta pública diretamente no portal da SEFAZ.

## ⚙️ Funcionalidades

- **Validação de Chaves de Acesso**: 
  - Verifica se a chave fornecida contém os 44 dígitos exigidos e segue o formato correto.
  - Retorna erros específicos para chaves inválidas.

- **Extração de Informações da Chave**: 
  - **UF de Emissão**: Identifica o estado (Unidade Federativa) onde a nota fiscal foi emitida.
  - **Ano e Mês de Emissão**: Extrai o ano e o mês com base na chave.
  - **CNPJ do Emitente**: Obtém o CNPJ do emissor da nota.
  - **Modelo da Nota**: Determina o modelo do documento (NF-e, NFC-e, CT-e, etc.).
  - **Série e Número**: Extrai a série e o número da nota fiscal.
  - **Modo de Emissão**: Verifica o método de emissão (normal, contingência, etc.).
  - **Chave Única**: Identifica o valor final único da chave.

- **Geração de Link de Consulta**: 
  - Retorna o link oficial da SEFAZ para consulta pública da nota fiscal.

## 🚀 Como Funciona

1. **Entrada**: O usuário fornece uma chave de acesso de 44 dígitos.
2. **Processamento**: A API valida e processa a chave, extraindo as informações detalhadas.
3. **Saída**: A API retorna um JSON contendo:
   - Validação da chave.
   - Informações extraídas.
   - Link de consulta pública.

