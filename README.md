# Simple Translator Project

This translator consists of 3 main methods.
1. **polish2English(polish2EnglishDictionaryPath, polishExpression)**
It returns translation to english of inserted polishExpression.

2. **polishToGerman(polish2EnglishDictionaryPath,
english2GermanDictionaryPath, polishExpression)**
It returns translation to german of inserted polishExpression.

3. **generateGermanToPolishTranslationFile(polish2EnglishDictionaryPath,
english2GermanDictionaryPath)**
It converts two files POL2ENG.txt and ENG2GER.txt into one file POL2GER.txt that contains translation of polish to german words.

**All data in files is in format:**
>czerwony;red  
fioletowy;violet  
jeden;one  
dwa;two  

etc.