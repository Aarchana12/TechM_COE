import 'dart:convert'; // To parse JSON
import 'dart:async'; // For Future
import 'package:flutter/services.dart'; // To load assets
import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';

class AppLocalization {
  final Locale locale;
  Map<String, String> _localizedStrings = {};

  AppLocalization(this.locale);

  static AppLocalization? of(BuildContext context) {
    return Localizations.of<AppLocalization>(context, AppLocalization);
  }

  static const LocalizationsDelegate<AppLocalization> delegate =
      _AppLocalizationDelegate();

  // Asynchronously load the localization JSON files based on the locale
  Future<bool> load() async {
    // Load the JSON from assets
    String jsonString = await rootBundle.loadString(
      'assets/lang/${locale.languageCode}.json',
    ); // Load the appropriate JSON file
    Map<String, dynamic> jsonMap = json.decode(jsonString); // Decode the JSON
    _localizedStrings = jsonMap.map(
      (key, value) => MapEntry(key.toString(), value.toString()),
    ); // Map the JSON to a Map<String, String>
    return true;
  }

  // Translate method to return the translation based on the key
  String translate(String key) {
    return _localizedStrings[key] ?? key; // Return the key if not found in JSON
  }
}

// Localization delegate that loads the localization when needed
class _AppLocalizationDelegate extends LocalizationsDelegate<AppLocalization> {
  const _AppLocalizationDelegate();

  @override
  bool isSupported(Locale locale) {
    // Supports English ('en') and Tamil ('ta') languages
    return ['en', 'ta'].contains(locale.languageCode);
  }

  @override
  Future<AppLocalization> load(Locale locale) async {
    AppLocalization localization = AppLocalization(locale);
    await localization
        .load(); // Load the translations from the corresponding JSON file
    return localization;
  }

  @override
  bool shouldReload(covariant LocalizationsDelegate<AppLocalization> old) {
    return false; // No need to reload unless language changes
  }
}
