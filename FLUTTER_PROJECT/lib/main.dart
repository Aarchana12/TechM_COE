import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:fixitnow/pages/home_screen.dart';
import 'package:fixitnow/pages/language_screen.dart';
import 'package:fixitnow/localization/app_localization.dart';
import 'package:shared_preferences/shared_preferences.dart'; // For persisting locale

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  Locale _locale = Locale('en'); // Default language

  @override
  void initState() {
    super.initState();
    _loadLocale(); // Load saved locale on app start
  }

  // Load saved locale from shared preferences
  void _loadLocale() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    String? languageCode = prefs.getString('language_code');
    if (languageCode != null) {
      setState(() {
        _locale = Locale(languageCode);
      });
    }
  }

  // Set locale and save preference to shared preferences
  void _setLocale(Locale locale) async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    await prefs.setString(
      'language_code',
      locale.languageCode,
    ); // Save language preference
    setState(() {
      _locale = locale;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: "FixItNow",
      theme: ThemeData(
        primarySwatch: Colors.blue,
        scaffoldBackgroundColor: Colors.grey[200],
      ),
      locale: _locale,
      supportedLocales: [Locale('en'), Locale('ta')],
      localizationsDelegates: [
        AppLocalization.delegate,
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        GlobalCupertinoLocalizations.delegate,
      ],
      home: HomeScreen(setLocale: _setLocale),
      routes: {'/language': (context) => LanguageScreen(setLocale: _setLocale)},
    );
  }
}
