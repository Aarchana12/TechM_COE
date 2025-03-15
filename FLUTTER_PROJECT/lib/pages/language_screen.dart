import 'package:flutter/material.dart';
import 'package:fixitnow/localization/app_localization.dart';

class LanguageScreen extends StatelessWidget {
  final Function(Locale) setLocale;

  LanguageScreen({required this.setLocale});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(AppLocalization.of(context)!.translate('select_language')),
      ),
      body: ListView(
        children: [
          ListTile(
            title: Text(AppLocalization.of(context)!.translate('english')),
            onTap: () {
              setLocale(Locale('en'));
              Navigator.pop(context);
            },
          ),
          ListTile(
            title: Text(AppLocalization.of(context)!.translate('tamil')),
            onTap: () {
              setLocale(Locale('ta'));
              Navigator.pop(context);
            },
          ),
        ],
      ),
    );
  }
}
