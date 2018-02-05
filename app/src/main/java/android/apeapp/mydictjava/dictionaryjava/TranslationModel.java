package android.apeapp.mydictjava.dictionaryjava;

import java.util.List;

/**
 * Created by ben on 6/2/18.
 */

public class TranslationModel {

    public class Data {

        public Translation data;

        public Translation getData() {
            return data;
        }

        public void setData(Translation data) {
            this.data = data;
        }
    }

    public class Translation {

        public List<TranslateResultBean> translations;

        public List<TranslateResultBean> getTranslations() {
            return translations;
        }

        public void setTranslations(List<TranslateResultBean> translations) {
            this.translations = translations;
        }


    }

    public class TranslateResultBean {

        public String translatedText;
        public String detectedSourceLanguage;

        public String getTranslatedText() {
            return translatedText;
        }

        public void setTranslatedText(String translatedText) {
            this.translatedText = translatedText;
        }

        public String getDetectedSourceLanguage() {
            return detectedSourceLanguage;
        }

        public void setDetectedSourceLanguage(String detectedSourceLanguage) {
            this.detectedSourceLanguage = detectedSourceLanguage;
        }
    }

}
