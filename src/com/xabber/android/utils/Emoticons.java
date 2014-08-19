/**
 * Copyright (c) 2013, Redsolution LTD. All rights reserved.
 * 
 * This file is part of Xabber project; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License, Version 3.
 * 
 * Xabber is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License,
 * along with this program. If not, see http://www.gnu.org/licenses/.
 */
package com.xabber.android.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ImageSpan;

import com.xabber.android.data.SettingsManager;
import com.xabber.androiddev.R;

/**
 * Emoticons.
 * 
 * @author alexander.ivanov
 * 
 */
public class Emoticons {

	public static final Map<Pattern, Integer> ANDROID_EMOTICONS = new HashMap<Pattern, Integer>();
	public static final Map<Pattern, Integer> SKYPE_EMOTICONS = new HashMap<Pattern, Integer>();
	public static final Map<Pattern, Integer> NONE_EMOTICONS = new HashMap<Pattern, Integer>();

	private static final Factory spannableFactory = Spannable.Factory
			.getInstance();

	static {
		addPattern(ANDROID_EMOTICONS, ":)", R.drawable.emo_im_happy);
		addPattern(ANDROID_EMOTICONS, ":-)", R.drawable.emo_im_happy);
		addPattern(ANDROID_EMOTICONS, ":(", R.drawable.emo_im_sad);
		addPattern(ANDROID_EMOTICONS, ":-(", R.drawable.emo_im_sad);
		addPattern(ANDROID_EMOTICONS, ";)", R.drawable.emo_im_winking);
		addPattern(ANDROID_EMOTICONS, ";-)", R.drawable.emo_im_winking);
		addPattern(ANDROID_EMOTICONS, ":P",
				R.drawable.emo_im_tongue_sticking_out);
		addPattern(ANDROID_EMOTICONS, ":-P",
				R.drawable.emo_im_tongue_sticking_out);
		addPattern(ANDROID_EMOTICONS, "=-O", R.drawable.emo_im_surprised);
		addPattern(ANDROID_EMOTICONS, ":*", R.drawable.emo_im_kissing);
		addPattern(ANDROID_EMOTICONS, ":-*", R.drawable.emo_im_kissing);
		addPattern(ANDROID_EMOTICONS, ":O", R.drawable.emo_im_wtf);
		addPattern(ANDROID_EMOTICONS, ":-O", R.drawable.emo_im_wtf);
		addPattern(ANDROID_EMOTICONS, "B)", R.drawable.emo_im_cool);
		addPattern(ANDROID_EMOTICONS, "B-)", R.drawable.emo_im_cool);
		addPattern(ANDROID_EMOTICONS, "8)", R.drawable.emo_im_cool);
		addPattern(ANDROID_EMOTICONS, "8-)", R.drawable.emo_im_cool);
		addPattern(ANDROID_EMOTICONS, ":$", R.drawable.emo_im_money_mouth);
		addPattern(ANDROID_EMOTICONS, ":-$", R.drawable.emo_im_money_mouth);
		addPattern(ANDROID_EMOTICONS, ":-!", R.drawable.emo_im_foot_in_mouth);
		addPattern(ANDROID_EMOTICONS, ":-[", R.drawable.emo_im_embarrassed);
		addPattern(ANDROID_EMOTICONS, "O:)", R.drawable.emo_im_angel);
		addPattern(ANDROID_EMOTICONS, "O:-)", R.drawable.emo_im_angel);
		addPattern(ANDROID_EMOTICONS, ":\\", R.drawable.emo_im_undecided);
		addPattern(ANDROID_EMOTICONS, ":-\\", R.drawable.emo_im_undecided);
		addPattern(ANDROID_EMOTICONS, ":'(", R.drawable.emo_im_crying);
		addPattern(ANDROID_EMOTICONS, ":D", R.drawable.emo_im_laughing);
		addPattern(ANDROID_EMOTICONS, ":-D", R.drawable.emo_im_laughing);
		addPattern(ANDROID_EMOTICONS, "O_o", R.drawable.emo_im_wtf);
		addPattern(ANDROID_EMOTICONS, "o_O", R.drawable.emo_im_wtf);
		addPattern(ANDROID_EMOTICONS, ">:O", R.drawable.emo_im_yelling);
		addPattern(ANDROID_EMOTICONS, ">:0", R.drawable.emo_im_yelling);
		addPattern(ANDROID_EMOTICONS, ":S", R.drawable.emo_im_lips_are_sealed);
		addPattern(ANDROID_EMOTICONS, ":-S", R.drawable.emo_im_lips_are_sealed);
		
		addPattern(SKYPE_EMOTICONS, ":)", R.drawable.emo_skype_smile);
		addPattern(SKYPE_EMOTICONS, ":=)", R.drawable.emo_skype_smile);
		addPattern(SKYPE_EMOTICONS, ":-)", R.drawable.emo_skype_smile);
		addPattern(SKYPE_EMOTICONS, ":(", R.drawable.emo_skype_sadsmile);
		addPattern(SKYPE_EMOTICONS, ":=(", R.drawable.emo_skype_sadsmile);
		addPattern(SKYPE_EMOTICONS, ":-(", R.drawable.emo_skype_sadsmile);
		addPattern(SKYPE_EMOTICONS, ":D", R.drawable.emo_skype_bigsmile);
		addPattern(SKYPE_EMOTICONS, ":=D", R.drawable.emo_skype_bigsmile);
		addPattern(SKYPE_EMOTICONS, ":-D", R.drawable.emo_skype_bigsmile);
		addPattern(SKYPE_EMOTICONS, ":d", R.drawable.emo_skype_bigsmile);
		addPattern(SKYPE_EMOTICONS, ":=d", R.drawable.emo_skype_bigsmile);
		addPattern(SKYPE_EMOTICONS, ":-d", R.drawable.emo_skype_bigsmile);
		addPattern(SKYPE_EMOTICONS, "8=)", R.drawable.emo_skype_cool);
		addPattern(SKYPE_EMOTICONS, "8-)", R.drawable.emo_skype_cool);
		addPattern(SKYPE_EMOTICONS, "B=)", R.drawable.emo_skype_cool);
		addPattern(SKYPE_EMOTICONS, "B-)", R.drawable.emo_skype_cool);
		addPattern(SKYPE_EMOTICONS, "(cool)", R.drawable.emo_skype_cool);
		addPattern(SKYPE_EMOTICONS, ";)", R.drawable.emo_skype_wink);
		addPattern(SKYPE_EMOTICONS, ";-)", R.drawable.emo_skype_wink);
		addPattern(SKYPE_EMOTICONS, ";=)", R.drawable.emo_skype_wink);
		addPattern(SKYPE_EMOTICONS, ":o", R.drawable.emo_skype_surprised);
		addPattern(SKYPE_EMOTICONS, ":=o", R.drawable.emo_skype_surprised);
		addPattern(SKYPE_EMOTICONS, ":-o", R.drawable.emo_skype_surprised);
		addPattern(SKYPE_EMOTICONS, ":O", R.drawable.emo_skype_surprised);
		addPattern(SKYPE_EMOTICONS, ":=O", R.drawable.emo_skype_surprised);
		addPattern(SKYPE_EMOTICONS, ":-O", R.drawable.emo_skype_surprised);
		addPattern(SKYPE_EMOTICONS, ";(", R.drawable.emo_skype_crying);
		addPattern(SKYPE_EMOTICONS, ";-(", R.drawable.emo_skype_crying);
		addPattern(SKYPE_EMOTICONS, ";=(", R.drawable.emo_skype_crying);
		addPattern(SKYPE_EMOTICONS, "(sweat)", R.drawable.emo_skype_sweating);
		addPattern(SKYPE_EMOTICONS, "(:|", R.drawable.emo_skype_sweating);
		addPattern(SKYPE_EMOTICONS, ":|", R.drawable.emo_skype_speechless);
		addPattern(SKYPE_EMOTICONS, ":=|", R.drawable.emo_skype_speechless);
		addPattern(SKYPE_EMOTICONS, ":-|", R.drawable.emo_skype_speechless);
		addPattern(SKYPE_EMOTICONS, ":*", R.drawable.emo_skype_kiss);
		addPattern(SKYPE_EMOTICONS, ":=*", R.drawable.emo_skype_kiss);
		addPattern(SKYPE_EMOTICONS, ":-*", R.drawable.emo_skype_kiss);
		addPattern(SKYPE_EMOTICONS, ":P", R.drawable.emo_skype_tongueout);
		addPattern(SKYPE_EMOTICONS, ":=P", R.drawable.emo_skype_tongueout);
		addPattern(SKYPE_EMOTICONS, ":-P", R.drawable.emo_skype_tongueout);
		addPattern(SKYPE_EMOTICONS, ":p", R.drawable.emo_skype_tongueout);
		addPattern(SKYPE_EMOTICONS, ":=p", R.drawable.emo_skype_tongueout);
		addPattern(SKYPE_EMOTICONS, ":-p", R.drawable.emo_skype_tongueout);
		addPattern(SKYPE_EMOTICONS, "(yn)", R.drawable.emo_skype_fingerscrossed);
		addPattern(SKYPE_EMOTICONS, "(blush)", R.drawable.emo_skype_blushing);
		addPattern(SKYPE_EMOTICONS, ":$", R.drawable.emo_skype_blushing);
		addPattern(SKYPE_EMOTICONS, ":-$", R.drawable.emo_skype_blushing);
		addPattern(SKYPE_EMOTICONS, ":=$", R.drawable.emo_skype_blushing);
		addPattern(SKYPE_EMOTICONS, ":\">", R.drawable.emo_skype_blushing);
		addPattern(SKYPE_EMOTICONS, ":^)", R.drawable.emo_skype_wondering);
		addPattern(SKYPE_EMOTICONS, "|-)", R.drawable.emo_skype_sleepy);
		addPattern(SKYPE_EMOTICONS, "I-)", R.drawable.emo_skype_sleepy);
		addPattern(SKYPE_EMOTICONS, "I=)", R.drawable.emo_skype_sleepy);
		addPattern(SKYPE_EMOTICONS, "(snooze)", R.drawable.emo_skype_sleepy);
		addPattern(SKYPE_EMOTICONS, "|(", R.drawable.emo_skype_dull);
		addPattern(SKYPE_EMOTICONS, "|-(", R.drawable.emo_skype_dull);
		addPattern(SKYPE_EMOTICONS, "|=(", R.drawable.emo_skype_dull);
		addPattern(SKYPE_EMOTICONS, "(inlove)", R.drawable.emo_skype_inlove);
		addPattern(SKYPE_EMOTICONS, "]:)", R.drawable.emo_skype_evilgrin);
		addPattern(SKYPE_EMOTICONS, ">:)", R.drawable.emo_skype_evilgrin);
		addPattern(SKYPE_EMOTICONS, "(grin)", R.drawable.emo_skype_evilgrin);
		addPattern(SKYPE_EMOTICONS, "(yawn)", R.drawable.emo_skype_yawning);
		addPattern(SKYPE_EMOTICONS, "(puke)", R.drawable.emo_skype_puking);
		addPattern(SKYPE_EMOTICONS, ":&", R.drawable.emo_skype_puking);
		addPattern(SKYPE_EMOTICONS, ":-&", R.drawable.emo_skype_puking);
		addPattern(SKYPE_EMOTICONS, ":=&", R.drawable.emo_skype_puking);
		addPattern(SKYPE_EMOTICONS, "(doh)", R.drawable.emo_skype_doh);
		addPattern(SKYPE_EMOTICONS, ":@", R.drawable.emo_skype_angry);
		addPattern(SKYPE_EMOTICONS, ":-@", R.drawable.emo_skype_angry);
		addPattern(SKYPE_EMOTICONS, ":=@", R.drawable.emo_skype_angry);
		addPattern(SKYPE_EMOTICONS, "x(", R.drawable.emo_skype_angry);
		addPattern(SKYPE_EMOTICONS, "x-(", R.drawable.emo_skype_angry);
		addPattern(SKYPE_EMOTICONS, "x=(", R.drawable.emo_skype_angry);
		addPattern(SKYPE_EMOTICONS, "X(", R.drawable.emo_skype_angry);
		addPattern(SKYPE_EMOTICONS, "X-", R.drawable.emo_skype_angry);
		addPattern(SKYPE_EMOTICONS, "(X=(", R.drawable.emo_skype_angry);
		addPattern(SKYPE_EMOTICONS, "(wasntme)", R.drawable.emo_skype_itwasntme);
		addPattern(SKYPE_EMOTICONS, "(party)", R.drawable.emo_skype_party);
		addPattern(SKYPE_EMOTICONS, "(facepalm)", R.drawable.emo_skype_facepalm);
		addPattern(SKYPE_EMOTICONS, ":S", R.drawable.emo_skype_worried);
		addPattern(SKYPE_EMOTICONS, ":-S", R.drawable.emo_skype_worried);
		addPattern(SKYPE_EMOTICONS, ":=S", R.drawable.emo_skype_worried);
		addPattern(SKYPE_EMOTICONS, ":s", R.drawable.emo_skype_worried);
		addPattern(SKYPE_EMOTICONS, ":-s", R.drawable.emo_skype_worried);
		addPattern(SKYPE_EMOTICONS, ":=s", R.drawable.emo_skype_worried);
		addPattern(SKYPE_EMOTICONS, "(mm)", R.drawable.emo_skype_mmm);
		addPattern(SKYPE_EMOTICONS, "8-|", R.drawable.emo_skype_nerd);
		addPattern(SKYPE_EMOTICONS, "B-|", R.drawable.emo_skype_nerd);
		addPattern(SKYPE_EMOTICONS, "8|", R.drawable.emo_skype_nerd);
		addPattern(SKYPE_EMOTICONS, "B|", R.drawable.emo_skype_nerd);
		addPattern(SKYPE_EMOTICONS, "8=|", R.drawable.emo_skype_nerd);
		addPattern(SKYPE_EMOTICONS, "B=|", R.drawable.emo_skype_nerd);
		addPattern(SKYPE_EMOTICONS, "(nerd)", R.drawable.emo_skype_nerd);
		addPattern(SKYPE_EMOTICONS, ":x", R.drawable.emo_skype_lipssealed);
		addPattern(SKYPE_EMOTICONS, ":-x:", R.drawable.emo_skype_lipssealed);
		addPattern(SKYPE_EMOTICONS, "X", R.drawable.emo_skype_lipssealed);
		addPattern(SKYPE_EMOTICONS, ":-X", R.drawable.emo_skype_lipssealed);
		addPattern(SKYPE_EMOTICONS, ":#", R.drawable.emo_skype_lipssealed);
		addPattern(SKYPE_EMOTICONS, ":-#", R.drawable.emo_skype_lipssealed);
		addPattern(SKYPE_EMOTICONS, ":=x", R.drawable.emo_skype_lipssealed);
		addPattern(SKYPE_EMOTICONS, ":=X", R.drawable.emo_skype_lipssealed);
		addPattern(SKYPE_EMOTICONS, ":=#", R.drawable.emo_skype_lipssealed);
		addPattern(SKYPE_EMOTICONS, "(hi)", R.drawable.emo_skype_hi);
		addPattern(SKYPE_EMOTICONS, "(devil)", R.drawable.emo_skype_devil);
		addPattern(SKYPE_EMOTICONS, "(angel)", R.drawable.emo_skype_angel);
		addPattern(SKYPE_EMOTICONS, "(envy)", R.drawable.emo_skype_envy);
		addPattern(SKYPE_EMOTICONS, "(wait)", R.drawable.emo_skype_wait);
		addPattern(SKYPE_EMOTICONS, "(bear)", R.drawable.emo_skype_hug);
		addPattern(SKYPE_EMOTICONS, "(hug)", R.drawable.emo_skype_hug);
		addPattern(SKYPE_EMOTICONS, "(makeup)", R.drawable.emo_skype_makeup);
		addPattern(SKYPE_EMOTICONS, "(kate)", R.drawable.emo_skype_makeup);
		addPattern(SKYPE_EMOTICONS, "(giggle)", R.drawable.emo_skype_giggle);
		addPattern(SKYPE_EMOTICONS, "(chuckle)", R.drawable.emo_skype_giggle);
		addPattern(SKYPE_EMOTICONS, "(clap)", R.drawable.emo_skype_clapping);
		addPattern(SKYPE_EMOTICONS, "(think)", R.drawable.emo_skype_thinking);
		addPattern(SKYPE_EMOTICONS, ":?", R.drawable.emo_skype_thinking);
		addPattern(SKYPE_EMOTICONS, ":-?", R.drawable.emo_skype_thinking);
		addPattern(SKYPE_EMOTICONS, ":=?", R.drawable.emo_skype_thinking);
		addPattern(SKYPE_EMOTICONS, "(bow)", R.drawable.emo_skype_bow);
		addPattern(SKYPE_EMOTICONS, "(rofl)", R.drawable.emo_skype_rofl);
		addPattern(SKYPE_EMOTICONS, "(whew)", R.drawable.emo_skype_whew);
		addPattern(SKYPE_EMOTICONS, "(happy)", R.drawable.emo_skype_happy);
		addPattern(SKYPE_EMOTICONS, "(smirk)", R.drawable.emo_skype_smirk);
		addPattern(SKYPE_EMOTICONS, "(nod)", R.drawable.emo_skype_nod);
		addPattern(SKYPE_EMOTICONS, "(shake)", R.drawable.emo_skype_shake);
		addPattern(SKYPE_EMOTICONS, "(emo)", R.drawable.emo_skype_emo);
		addPattern(SKYPE_EMOTICONS, "(y)", R.drawable.emo_skype_yes);
		addPattern(SKYPE_EMOTICONS, "(Y)", R.drawable.emo_skype_yes);
		addPattern(SKYPE_EMOTICONS, "(ok)", R.drawable.emo_skype_yes);
		addPattern(SKYPE_EMOTICONS, "(n)", R.drawable.emo_skype_no);
		addPattern(SKYPE_EMOTICONS, "(N)", R.drawable.emo_skype_no);
		addPattern(SKYPE_EMOTICONS, "(handshake)", R.drawable.emo_skype_handshake);
		addPattern(SKYPE_EMOTICONS, "(h)", R.drawable.emo_skype_heart);
		addPattern(SKYPE_EMOTICONS, "(H)", R.drawable.emo_skype_heart);
		addPattern(SKYPE_EMOTICONS, "(l)", R.drawable.emo_skype_heart);
		addPattern(SKYPE_EMOTICONS, "(L)", R.drawable.emo_skype_heart);
		addPattern(SKYPE_EMOTICONS, "(tmi)", R.drawable.emo_skype_tmi);
		addPattern(SKYPE_EMOTICONS, "(heidy)", R.drawable.emo_skype_heidy);
		addPattern(SKYPE_EMOTICONS, "(f)", R.drawable.emo_skype_flower);
		addPattern(SKYPE_EMOTICONS, "(F)", R.drawable.emo_skype_flower);
		addPattern(SKYPE_EMOTICONS, "(rain)", R.drawable.emo_skype_rain);
		addPattern(SKYPE_EMOTICONS, "(london)", R.drawable.emo_skype_rain);
		addPattern(SKYPE_EMOTICONS, "(st)", R.drawable.emo_skype_rain);
		addPattern(SKYPE_EMOTICONS, "(sun)", R.drawable.emo_skype_sunshine);
		addPattern(SKYPE_EMOTICONS, "(music)", R.drawable.emo_skype_music);
		addPattern(SKYPE_EMOTICONS, "(coffee)", R.drawable.emo_skype_coffee);
		addPattern(SKYPE_EMOTICONS, "(pizza)", R.drawable.emo_skype_pizza);
		addPattern(SKYPE_EMOTICONS, "(pi)", R.drawable.emo_skype_pizza);
		addPattern(SKYPE_EMOTICONS, "(cash)", R.drawable.emo_skype_cash);
		addPattern(SKYPE_EMOTICONS, "(mo)", R.drawable.emo_skype_cash);
		addPattern(SKYPE_EMOTICONS, "($)", R.drawable.emo_skype_cash);
		addPattern(SKYPE_EMOTICONS, "(muscle)", R.drawable.emo_skype_muscle);
		addPattern(SKYPE_EMOTICONS, "(flex)", R.drawable.emo_skype_muscle);
		addPattern(SKYPE_EMOTICONS, "(^)", R.drawable.emo_skype_cake);
		addPattern(SKYPE_EMOTICONS, "(cake)", R.drawable.emo_skype_cake);
		addPattern(SKYPE_EMOTICONS, "(beer)", R.drawable.emo_skype_beer);
		addPattern(SKYPE_EMOTICONS, "(d)", R.drawable.emo_skype_drink);
		addPattern(SKYPE_EMOTICONS, "(D)", R.drawable.emo_skype_drink);
		addPattern(SKYPE_EMOTICONS, "(dance)", R.drawable.emo_skype_dancing);
		addPattern(SKYPE_EMOTICONS, "\\o/", R.drawable.emo_skype_dancing);
		addPattern(SKYPE_EMOTICONS, "\\:D/", R.drawable.emo_skype_dancing);
		addPattern(SKYPE_EMOTICONS, "\\:d/", R.drawable.emo_skype_dancing);
		addPattern(SKYPE_EMOTICONS, "(ninja)", R.drawable.emo_skype_ninja);
		addPattern(SKYPE_EMOTICONS, "(*)", R.drawable.emo_skype_star);
		addPattern(SKYPE_EMOTICONS, "(tumbleweed)", R.drawable.emo_skype_tumbleweed);
		addPattern(SKYPE_EMOTICONS, "(bandit)", R.drawable.emo_skype_bandit);
		addPattern(SKYPE_EMOTICONS, "(skype)", R.drawable.emo_skype_skype);
		addPattern(SKYPE_EMOTICONS, "(ss)", R.drawable.emo_skype_skype);
		addPattern(SKYPE_EMOTICONS, "(call)", R.drawable.emo_skype_call);
		addPattern(SKYPE_EMOTICONS, "(talk)", R.drawable.emo_skype_talking);
		addPattern(SKYPE_EMOTICONS, "(u)", R.drawable.emo_skype_brokenheart);
		addPattern(SKYPE_EMOTICONS, "(U)", R.drawable.emo_skype_brokenheart);
		addPattern(SKYPE_EMOTICONS, "(o)", R.drawable.emo_skype_time);
		addPattern(SKYPE_EMOTICONS, "(O)", R.drawable.emo_skype_time);
		addPattern(SKYPE_EMOTICONS, "(time)", R.drawable.emo_skype_time);
		addPattern(SKYPE_EMOTICONS, "(e)", R.drawable.emo_skype_mail);
		addPattern(SKYPE_EMOTICONS, "(m)", R.drawable.emo_skype_mail);
		addPattern(SKYPE_EMOTICONS, "(~)", R.drawable.emo_skype_movie);
		addPattern(SKYPE_EMOTICONS, "(film)", R.drawable.emo_skype_movie);
		addPattern(SKYPE_EMOTICONS, "(movie)", R.drawable.emo_skype_movie);
		addPattern(SKYPE_EMOTICONS, "(mp)", R.drawable.emo_skype_phone);
		addPattern(SKYPE_EMOTICONS, "(ph)", R.drawable.emo_skype_phone);
		addPattern(SKYPE_EMOTICONS, "(drunk)", R.drawable.emo_skype_drunk);
		addPattern(SKYPE_EMOTICONS, "(punch)", R.drawable.emo_skype_punch);
		addPattern(SKYPE_EMOTICONS, "(smoking)", R.drawable.emo_skype_smoking);
		addPattern(SKYPE_EMOTICONS, "(smoke)", R.drawable.emo_skype_smoking);
		addPattern(SKYPE_EMOTICONS, "(ci)", R.drawable.emo_skype_smoking);
		addPattern(SKYPE_EMOTICONS, "(toivo)", R.drawable.emo_skype_toivo);
		addPattern(SKYPE_EMOTICONS, "(rock)", R.drawable.emo_skype_rock);
		addPattern(SKYPE_EMOTICONS, "(headbang)", R.drawable.emo_skype_headbang);
		addPattern(SKYPE_EMOTICONS, "(banghead)", R.drawable.emo_skype_headbang);
		addPattern(SKYPE_EMOTICONS, "(bug)", R.drawable.emo_skype_bug);
		addPattern(SKYPE_EMOTICONS, "(poolparty)", R.drawable.emo_skype_poolparty);
		addPattern(SKYPE_EMOTICONS, "(talktothehand)", R.drawable.emo_skype_talktothehand);
		addPattern(SKYPE_EMOTICONS, "(idea)", R.drawable.emo_skype_idea);
		addPattern(SKYPE_EMOTICONS, "(sheep)", R.drawable.emo_skype_sheep);
		addPattern(SKYPE_EMOTICONS, "(cat)&nbsp;", R.drawable.emo_skype_cat);
		addPattern(SKYPE_EMOTICONS, ":3", R.drawable.emo_skype_cat);
		addPattern(SKYPE_EMOTICONS, "(bike)", R.drawable.emo_skype_bike);
		addPattern(SKYPE_EMOTICONS, "(dog)", R.drawable.emo_skype_dog);
		addPattern(SKYPE_EMOTICONS, "(flag:AF)", R.drawable.emo_skype_flag_af);
		addPattern(SKYPE_EMOTICONS, "(flag:AL)", R.drawable.emo_skype_flag_al);
		addPattern(SKYPE_EMOTICONS, "(flag:DZ)", R.drawable.emo_skype_flag_dz);
		addPattern(SKYPE_EMOTICONS, "(flag:AS)", R.drawable.emo_skype_flag_as);
		addPattern(SKYPE_EMOTICONS, "(flag:AD)", R.drawable.emo_skype_flag_ad);
		addPattern(SKYPE_EMOTICONS, "(flag:AO)", R.drawable.emo_skype_flag_ao);
		addPattern(SKYPE_EMOTICONS, "(flag:AI)", R.drawable.emo_skype_flag_ai);
		addPattern(SKYPE_EMOTICONS, "(flag:AQ)", R.drawable.emo_skype_flag_aq);
		addPattern(SKYPE_EMOTICONS, "(flag:AG)", R.drawable.emo_skype_flag_ag);
		addPattern(SKYPE_EMOTICONS, "(flag:AR)", R.drawable.emo_skype_flag_ar);
		addPattern(SKYPE_EMOTICONS, "(flag:AM)", R.drawable.emo_skype_flag_am);
		addPattern(SKYPE_EMOTICONS, "(flag:AW)", R.drawable.emo_skype_flag_aw);
		addPattern(SKYPE_EMOTICONS, "(flag:AU)", R.drawable.emo_skype_flag_au);
		addPattern(SKYPE_EMOTICONS, "(flag:AT)", R.drawable.emo_skype_flag_at);
		addPattern(SKYPE_EMOTICONS, "(flag:AZ)", R.drawable.emo_skype_flag_az);
		addPattern(SKYPE_EMOTICONS, "(flag:BS)", R.drawable.emo_skype_flag_bs);
		addPattern(SKYPE_EMOTICONS, "(flag:BH)", R.drawable.emo_skype_flag_bh);
		addPattern(SKYPE_EMOTICONS, "(flag:BD)", R.drawable.emo_skype_flag_bd);
		addPattern(SKYPE_EMOTICONS, "(flag:BB)", R.drawable.emo_skype_flag_bb);
		addPattern(SKYPE_EMOTICONS, "(flag:BY)", R.drawable.emo_skype_flag_by);
		addPattern(SKYPE_EMOTICONS, "(flag:BE)", R.drawable.emo_skype_flag_be);
		addPattern(SKYPE_EMOTICONS, "(flag:BZ)", R.drawable.emo_skype_flag_bz);
		addPattern(SKYPE_EMOTICONS, "(flag:BJ)", R.drawable.emo_skype_flag_bj);
		addPattern(SKYPE_EMOTICONS, "(flag:BM)", R.drawable.emo_skype_flag_bm);
		addPattern(SKYPE_EMOTICONS, "(flag:BT)", R.drawable.emo_skype_flag_bt);
		addPattern(SKYPE_EMOTICONS, "(flag:BO)", R.drawable.emo_skype_flag_bo);
		addPattern(SKYPE_EMOTICONS, "(flag:BA)", R.drawable.emo_skype_flag_ba);
		addPattern(SKYPE_EMOTICONS, "(flag:BW)", R.drawable.emo_skype_flag_bw);
		addPattern(SKYPE_EMOTICONS, "(flag:BR)", R.drawable.emo_skype_flag_br);
		addPattern(SKYPE_EMOTICONS, "(flag:IO)", R.drawable.emo_skype_flag_io);
		addPattern(SKYPE_EMOTICONS, "(flag:VG)", R.drawable.emo_skype_flag_vg);
		addPattern(SKYPE_EMOTICONS, "(flag:BN)", R.drawable.emo_skype_flag_bn);
		addPattern(SKYPE_EMOTICONS, "(flag:BG)", R.drawable.emo_skype_flag_bg);
		addPattern(SKYPE_EMOTICONS, "(flag:BF)", R.drawable.emo_skype_flag_bf);
		addPattern(SKYPE_EMOTICONS, "(flag:BI)", R.drawable.emo_skype_flag_bi);
		addPattern(SKYPE_EMOTICONS, "(flag:KH)", R.drawable.emo_skype_flag_kh);
		addPattern(SKYPE_EMOTICONS, "(flag:CM)", R.drawable.emo_skype_flag_cm);
		addPattern(SKYPE_EMOTICONS, "(flag:CA)", R.drawable.emo_skype_flag_ca);
		addPattern(SKYPE_EMOTICONS, "(flag:CV)", R.drawable.emo_skype_flag_cv);
		addPattern(SKYPE_EMOTICONS, "(flag:KY)", R.drawable.emo_skype_flag_ky);
		addPattern(SKYPE_EMOTICONS, "(flag:CF)", R.drawable.emo_skype_flag_cf);
		addPattern(SKYPE_EMOTICONS, "(flag:TD)", R.drawable.emo_skype_flag_td);
		addPattern(SKYPE_EMOTICONS, "(flag:CL)", R.drawable.emo_skype_flag_cl);
		addPattern(SKYPE_EMOTICONS, "(flag:CN)", R.drawable.emo_skype_flag_cn);
		addPattern(SKYPE_EMOTICONS, "(flag:CX)", R.drawable.emo_skype_flag_cx);
		addPattern(SKYPE_EMOTICONS, "(flag:CC)", R.drawable.emo_skype_flag_cc);
		addPattern(SKYPE_EMOTICONS, "(flag:CO)", R.drawable.emo_skype_flag_co);
		addPattern(SKYPE_EMOTICONS, "(flag:KM)", R.drawable.emo_skype_flag_km);
		addPattern(SKYPE_EMOTICONS, "(flag:CD)", R.drawable.emo_skype_flag_cd);
		addPattern(SKYPE_EMOTICONS, "(flag:CG)", R.drawable.emo_skype_flag_cg);
		addPattern(SKYPE_EMOTICONS, "(flag:CK)", R.drawable.emo_skype_flag_ck);
		addPattern(SKYPE_EMOTICONS, "(flag:CR)", R.drawable.emo_skype_flag_cr);
		addPattern(SKYPE_EMOTICONS, "(flag:CI)", R.drawable.emo_skype_flag_ci);
		addPattern(SKYPE_EMOTICONS, "(flag:HR)", R.drawable.emo_skype_flag_hr);
		addPattern(SKYPE_EMOTICONS, "(flag:CU)", R.drawable.emo_skype_flag_cu);
		addPattern(SKYPE_EMOTICONS, "(flag:CY)", R.drawable.emo_skype_flag_cy);
		addPattern(SKYPE_EMOTICONS, "(flag:CZ)", R.drawable.emo_skype_flag_cz);
		addPattern(SKYPE_EMOTICONS, "(flag:DK)", R.drawable.emo_skype_flag_dk);
		addPattern(SKYPE_EMOTICONS, "(flag:DJ)", R.drawable.emo_skype_flag_dj);
		addPattern(SKYPE_EMOTICONS, "(flag:DM)", R.drawable.emo_skype_flag_dm);
		addPattern(SKYPE_EMOTICONS, "(flag:DO)", R.drawable.emo_skype_flag_do);
		addPattern(SKYPE_EMOTICONS, "(flag:EC)", R.drawable.emo_skype_flag_ec);
		addPattern(SKYPE_EMOTICONS, "(flag:EG)", R.drawable.emo_skype_flag_eg);
		addPattern(SKYPE_EMOTICONS, "(flag:EU)", R.drawable.emo_skype_flag_eu);
		addPattern(SKYPE_EMOTICONS, "(flag:SV)", R.drawable.emo_skype_flag_sv);
		addPattern(SKYPE_EMOTICONS, "(flag:GQ)", R.drawable.emo_skype_flag_gq);
		addPattern(SKYPE_EMOTICONS, "(flag:ER)", R.drawable.emo_skype_flag_er);
		addPattern(SKYPE_EMOTICONS, "(flag:EE)", R.drawable.emo_skype_flag_ee);
		addPattern(SKYPE_EMOTICONS, "(flag:ET)", R.drawable.emo_skype_flag_et);
		addPattern(SKYPE_EMOTICONS, "(flag:FO)", R.drawable.emo_skype_flag_fo);
		addPattern(SKYPE_EMOTICONS, "(flag:FK)", R.drawable.emo_skype_flag_fk);
		addPattern(SKYPE_EMOTICONS, "(flag:FJ)", R.drawable.emo_skype_flag_fj);
		addPattern(SKYPE_EMOTICONS, "(flag:FI)", R.drawable.emo_skype_flag_fi);
		addPattern(SKYPE_EMOTICONS, "(flag:FR)", R.drawable.emo_skype_flag_fr);
		addPattern(SKYPE_EMOTICONS, "(flag:GF)", R.drawable.emo_skype_flag_gf);
		addPattern(SKYPE_EMOTICONS, "(flag:PF)", R.drawable.emo_skype_flag_pf);
		addPattern(SKYPE_EMOTICONS, "(flag:TF)", R.drawable.emo_skype_flag_tf);
		addPattern(SKYPE_EMOTICONS, "(flag:GA)", R.drawable.emo_skype_flag_ga);
		addPattern(SKYPE_EMOTICONS, "(flag:GM)", R.drawable.emo_skype_flag_gm);
		addPattern(SKYPE_EMOTICONS, "(flag:GE)", R.drawable.emo_skype_flag_ge);
		addPattern(SKYPE_EMOTICONS, "(flag:DE)", R.drawable.emo_skype_flag_de);
		addPattern(SKYPE_EMOTICONS, "(flag:GH)", R.drawable.emo_skype_flag_gh);
		addPattern(SKYPE_EMOTICONS, "(flag:GI)", R.drawable.emo_skype_flag_gi);
		addPattern(SKYPE_EMOTICONS, "(flag:GR)", R.drawable.emo_skype_flag_gr);
		addPattern(SKYPE_EMOTICONS, "(flag:GL)", R.drawable.emo_skype_flag_gl);
		addPattern(SKYPE_EMOTICONS, "(flag:GD)", R.drawable.emo_skype_flag_gd);
		addPattern(SKYPE_EMOTICONS, "(flag:GP)", R.drawable.emo_skype_flag_gp);
		addPattern(SKYPE_EMOTICONS, "(flag:GU)", R.drawable.emo_skype_flag_gu);
		addPattern(SKYPE_EMOTICONS, "(flag:GT)", R.drawable.emo_skype_flag_gt);
		addPattern(SKYPE_EMOTICONS, "(flag:GN)", R.drawable.emo_skype_flag_gn);
		addPattern(SKYPE_EMOTICONS, "(flag:GW)", R.drawable.emo_skype_flag_gw);
		addPattern(SKYPE_EMOTICONS, "(flag:GY)", R.drawable.emo_skype_flag_gy);
		addPattern(SKYPE_EMOTICONS, "(flag:HT)", R.drawable.emo_skype_flag_ht);
		addPattern(SKYPE_EMOTICONS, "(flag:HM)", R.drawable.emo_skype_flag_hm);
		addPattern(SKYPE_EMOTICONS, "(flag:VA)", R.drawable.emo_skype_flag_va);
		addPattern(SKYPE_EMOTICONS, "(flag:HN)", R.drawable.emo_skype_flag_hn);
		addPattern(SKYPE_EMOTICONS, "(flag:HK)", R.drawable.emo_skype_flag_hk);
		addPattern(SKYPE_EMOTICONS, "(flag:HU)", R.drawable.emo_skype_flag_hu);
		addPattern(SKYPE_EMOTICONS, "(flag:IS)", R.drawable.emo_skype_flag_is);
		addPattern(SKYPE_EMOTICONS, "(flag:IN)", R.drawable.emo_skype_flag_in);
		addPattern(SKYPE_EMOTICONS, "(flag:ID)", R.drawable.emo_skype_flag_id);
		addPattern(SKYPE_EMOTICONS, "(flag:IR)", R.drawable.emo_skype_flag_ir);
		addPattern(SKYPE_EMOTICONS, "(flag:IQ)", R.drawable.emo_skype_flag_iq);
		addPattern(SKYPE_EMOTICONS, "(flag:IE)", R.drawable.emo_skype_flag_ie);
		addPattern(SKYPE_EMOTICONS, "(flag:IL)", R.drawable.emo_skype_flag_il);
		addPattern(SKYPE_EMOTICONS, "(flag:IT)", R.drawable.emo_skype_flag_it);
		addPattern(SKYPE_EMOTICONS, "(flag:JM)", R.drawable.emo_skype_flag_jm);
		addPattern(SKYPE_EMOTICONS, "(flag:JP)", R.drawable.emo_skype_flag_jp);
		addPattern(SKYPE_EMOTICONS, "(flag:JO)", R.drawable.emo_skype_flag_jo);
		addPattern(SKYPE_EMOTICONS, "(flag:KZ)", R.drawable.emo_skype_flag_kz);
		addPattern(SKYPE_EMOTICONS, "(flag:KE)", R.drawable.emo_skype_flag_ke);
		addPattern(SKYPE_EMOTICONS, "(flag:KI)", R.drawable.emo_skype_flag_ki);
		addPattern(SKYPE_EMOTICONS, "(flag:KP)", R.drawable.emo_skype_flag_kp);
		addPattern(SKYPE_EMOTICONS, "(flag:KR)", R.drawable.emo_skype_flag_kr);
		addPattern(SKYPE_EMOTICONS, "(flag:KW)", R.drawable.emo_skype_flag_kw);
		addPattern(SKYPE_EMOTICONS, "(flag:KG)", R.drawable.emo_skype_flag_kg);
		addPattern(SKYPE_EMOTICONS, "(flag:LA)", R.drawable.emo_skype_flag_la);
		addPattern(SKYPE_EMOTICONS, "(flag:LV)", R.drawable.emo_skype_flag_lv);
		addPattern(SKYPE_EMOTICONS, "(flag:LB)", R.drawable.emo_skype_flag_lb);
		addPattern(SKYPE_EMOTICONS, "(flag:LS)", R.drawable.emo_skype_flag_ls);
		addPattern(SKYPE_EMOTICONS, "(flag:LR)", R.drawable.emo_skype_flag_lr);
		addPattern(SKYPE_EMOTICONS, "(flag:LY)", R.drawable.emo_skype_flag_ly);
		addPattern(SKYPE_EMOTICONS, "(flag:LI)", R.drawable.emo_skype_flag_li);
		addPattern(SKYPE_EMOTICONS, "(flag:LT)", R.drawable.emo_skype_flag_lt);
		addPattern(SKYPE_EMOTICONS, "(flag:LU)", R.drawable.emo_skype_flag_lu);
		addPattern(SKYPE_EMOTICONS, "(flag:MO)", R.drawable.emo_skype_flag_mo);
		addPattern(SKYPE_EMOTICONS, "(flag:ME)", R.drawable.emo_skype_flag_me);
		addPattern(SKYPE_EMOTICONS, "(flag:MK)", R.drawable.emo_skype_flag_mk);
		addPattern(SKYPE_EMOTICONS, "(flag:MG)", R.drawable.emo_skype_flag_mg);
		addPattern(SKYPE_EMOTICONS, "(flag:MW)", R.drawable.emo_skype_flag_mw);
		addPattern(SKYPE_EMOTICONS, "(flag:MY)", R.drawable.emo_skype_flag_my);
		addPattern(SKYPE_EMOTICONS, "(flag:MV)", R.drawable.emo_skype_flag_mv);
		addPattern(SKYPE_EMOTICONS, "(flag:ML)", R.drawable.emo_skype_flag_ml);
		addPattern(SKYPE_EMOTICONS, "(flag:MT)", R.drawable.emo_skype_flag_mt);
		addPattern(SKYPE_EMOTICONS, "(flag:MH)", R.drawable.emo_skype_flag_mh);
		addPattern(SKYPE_EMOTICONS, "(flag:MQ)", R.drawable.emo_skype_flag_mq);
		addPattern(SKYPE_EMOTICONS, "(flag:MR)", R.drawable.emo_skype_flag_mr);
		addPattern(SKYPE_EMOTICONS, "(flag:MU)", R.drawable.emo_skype_flag_mu);
		addPattern(SKYPE_EMOTICONS, "(flag:YT)", R.drawable.emo_skype_flag_yt);
		addPattern(SKYPE_EMOTICONS, "(flag:MX)", R.drawable.emo_skype_flag_mx);
		addPattern(SKYPE_EMOTICONS, "(flag:FM)", R.drawable.emo_skype_flag_fm);
		addPattern(SKYPE_EMOTICONS, "(flag:MD)", R.drawable.emo_skype_flag_md);
		addPattern(SKYPE_EMOTICONS, "(flag:MC)", R.drawable.emo_skype_flag_mc);
		addPattern(SKYPE_EMOTICONS, "(flag:MN)", R.drawable.emo_skype_flag_mn);
		addPattern(SKYPE_EMOTICONS, "(flag:ME)", R.drawable.emo_skype_flag_me);
		addPattern(SKYPE_EMOTICONS, "(flag:MS)", R.drawable.emo_skype_flag_ms);
		addPattern(SKYPE_EMOTICONS, "(flag:MA)", R.drawable.emo_skype_flag_ma);
		addPattern(SKYPE_EMOTICONS, "(flag:MZ)", R.drawable.emo_skype_flag_mz);
		addPattern(SKYPE_EMOTICONS, "(flag:MM)", R.drawable.emo_skype_flag_mm);
		addPattern(SKYPE_EMOTICONS, "(flag:NA)", R.drawable.emo_skype_flag_na);
		addPattern(SKYPE_EMOTICONS, "(flag:NR)", R.drawable.emo_skype_flag_nr);
		addPattern(SKYPE_EMOTICONS, "(flag:NP)", R.drawable.emo_skype_flag_np);
		addPattern(SKYPE_EMOTICONS, "(flag:NL)", R.drawable.emo_skype_flag_nl);
		addPattern(SKYPE_EMOTICONS, "(flag:NC)", R.drawable.emo_skype_flag_nc);
		addPattern(SKYPE_EMOTICONS, "(flag:NZ)", R.drawable.emo_skype_flag_nz);
		addPattern(SKYPE_EMOTICONS, "(flag:NI)", R.drawable.emo_skype_flag_ni);
		addPattern(SKYPE_EMOTICONS, "(flag:NE)", R.drawable.emo_skype_flag_ne);
		addPattern(SKYPE_EMOTICONS, "(flag:NG)", R.drawable.emo_skype_flag_ng);
		addPattern(SKYPE_EMOTICONS, "(flag:NU)", R.drawable.emo_skype_flag_nu);
		addPattern(SKYPE_EMOTICONS, "(flag:NF)", R.drawable.emo_skype_flag_nf);
		addPattern(SKYPE_EMOTICONS, "(flag:MP)", R.drawable.emo_skype_flag_mp);
		addPattern(SKYPE_EMOTICONS, "(flag:NO)", R.drawable.emo_skype_flag_no);
		addPattern(SKYPE_EMOTICONS, "(flag:OM)", R.drawable.emo_skype_flag_om);
		addPattern(SKYPE_EMOTICONS, "(flag:PK)", R.drawable.emo_skype_flag_pk);
		addPattern(SKYPE_EMOTICONS, "(flag:PW)", R.drawable.emo_skype_flag_pw);
		addPattern(SKYPE_EMOTICONS, "(flag:PS)", R.drawable.emo_skype_flag_ps);
		addPattern(SKYPE_EMOTICONS, "(flag:PA)", R.drawable.emo_skype_flag_pa);
		addPattern(SKYPE_EMOTICONS, "(flag:PG)", R.drawable.emo_skype_flag_pg);
		addPattern(SKYPE_EMOTICONS, "(flag:PY)", R.drawable.emo_skype_flag_py);
		addPattern(SKYPE_EMOTICONS, "(flag:PE)", R.drawable.emo_skype_flag_pe);
		addPattern(SKYPE_EMOTICONS, "(flag:PH)", R.drawable.emo_skype_flag_ph);
		addPattern(SKYPE_EMOTICONS, "(flag:PN)", R.drawable.emo_skype_flag_pn);
		addPattern(SKYPE_EMOTICONS, "(flag:PL)", R.drawable.emo_skype_flag_pl);
		addPattern(SKYPE_EMOTICONS, "(flag:PT)", R.drawable.emo_skype_flag_pt);
		addPattern(SKYPE_EMOTICONS, "(flag:PR)", R.drawable.emo_skype_flag_pr);
		addPattern(SKYPE_EMOTICONS, "(flag:QA)", R.drawable.emo_skype_flag_qa);
		addPattern(SKYPE_EMOTICONS, "(flag:RE)", R.drawable.emo_skype_flag_re);
		addPattern(SKYPE_EMOTICONS, "(flag:RO)", R.drawable.emo_skype_flag_ro);
		addPattern(SKYPE_EMOTICONS, "(flag:RU)", R.drawable.emo_skype_flag_ru);
		addPattern(SKYPE_EMOTICONS, "(flag:RW)", R.drawable.emo_skype_flag_rw);
		addPattern(SKYPE_EMOTICONS, "(flag:RS)", R.drawable.emo_skype_flag_rs);
		addPattern(SKYPE_EMOTICONS, "(flag:SS)", R.drawable.emo_skype_flag_ss);
		addPattern(SKYPE_EMOTICONS, "(flag:WS)", R.drawable.emo_skype_flag_ws);
		addPattern(SKYPE_EMOTICONS, "(flag:SM)", R.drawable.emo_skype_flag_sm);
		addPattern(SKYPE_EMOTICONS, "(flag:ST)", R.drawable.emo_skype_flag_st);
		addPattern(SKYPE_EMOTICONS, "(flag:SA)", R.drawable.emo_skype_flag_sa);
		addPattern(SKYPE_EMOTICONS, "(flag:SN)", R.drawable.emo_skype_flag_sn);
		addPattern(SKYPE_EMOTICONS, "(flag:RS)", R.drawable.emo_skype_flag_rs);
		addPattern(SKYPE_EMOTICONS, "(flag:SC)", R.drawable.emo_skype_flag_sc);
		addPattern(SKYPE_EMOTICONS, "(flag:SL)", R.drawable.emo_skype_flag_sl);
		addPattern(SKYPE_EMOTICONS, "(flag:SG)", R.drawable.emo_skype_flag_sg);
		addPattern(SKYPE_EMOTICONS, "(flag:SK)", R.drawable.emo_skype_flag_sk);
		addPattern(SKYPE_EMOTICONS, "(flag:SI)", R.drawable.emo_skype_flag_si);
		addPattern(SKYPE_EMOTICONS, "(flag:SB)", R.drawable.emo_skype_flag_sb);
		addPattern(SKYPE_EMOTICONS, "(flag:SO)", R.drawable.emo_skype_flag_so);
		addPattern(SKYPE_EMOTICONS, "(flag:ES)", R.drawable.emo_skype_flag_es);
		addPattern(SKYPE_EMOTICONS, "(flag:LK)", R.drawable.emo_skype_flag_lk);
		addPattern(SKYPE_EMOTICONS, "(flag:SH)", R.drawable.emo_skype_flag_sh);
		addPattern(SKYPE_EMOTICONS, "(flag:KN)", R.drawable.emo_skype_flag_kn);
		addPattern(SKYPE_EMOTICONS, "(flag:LC)", R.drawable.emo_skype_flag_lc);
		addPattern(SKYPE_EMOTICONS, "(flag:PM)", R.drawable.emo_skype_flag_pm);
		addPattern(SKYPE_EMOTICONS, "(flag:VC)", R.drawable.emo_skype_flag_vc);
		addPattern(SKYPE_EMOTICONS, "(flag:SD)", R.drawable.emo_skype_flag_sd);
		addPattern(SKYPE_EMOTICONS, "(flag:SR)", R.drawable.emo_skype_flag_sr);
		addPattern(SKYPE_EMOTICONS, "(flag:SZ)", R.drawable.emo_skype_flag_sz);
		addPattern(SKYPE_EMOTICONS, "(flag:SE)", R.drawable.emo_skype_flag_se);
		addPattern(SKYPE_EMOTICONS, "(flag:CH)", R.drawable.emo_skype_flag_ch);
		addPattern(SKYPE_EMOTICONS, "(flag:SY)", R.drawable.emo_skype_flag_sy);
		addPattern(SKYPE_EMOTICONS, "(flag:TW)", R.drawable.emo_skype_flag_tw);
		addPattern(SKYPE_EMOTICONS, "(flag:TJ)", R.drawable.emo_skype_flag_tj);
		addPattern(SKYPE_EMOTICONS, "(flag:TZ)", R.drawable.emo_skype_flag_tz);
		addPattern(SKYPE_EMOTICONS, "(flag:TH)", R.drawable.emo_skype_flag_th);
		addPattern(SKYPE_EMOTICONS, "(flag:TL)", R.drawable.emo_skype_flag_tl);
		addPattern(SKYPE_EMOTICONS, "(flag:TG)", R.drawable.emo_skype_flag_tg);
		addPattern(SKYPE_EMOTICONS, "(flag:TK)", R.drawable.emo_skype_flag_tk);
		addPattern(SKYPE_EMOTICONS, "(flag:TO)", R.drawable.emo_skype_flag_to);
		addPattern(SKYPE_EMOTICONS, "(flag:TT)", R.drawable.emo_skype_flag_tt);
		addPattern(SKYPE_EMOTICONS, "(flag:TN)", R.drawable.emo_skype_flag_tn);
		addPattern(SKYPE_EMOTICONS, "(flag:TR)", R.drawable.emo_skype_flag_tr);
		addPattern(SKYPE_EMOTICONS, "(flag:TM)", R.drawable.emo_skype_flag_tm);
		addPattern(SKYPE_EMOTICONS, "(flag:TC)", R.drawable.emo_skype_flag_tc);
		addPattern(SKYPE_EMOTICONS, "(flag:TV)", R.drawable.emo_skype_flag_tv);
		addPattern(SKYPE_EMOTICONS, "(flag:VI)", R.drawable.emo_skype_flag_vi);
		addPattern(SKYPE_EMOTICONS, "(flag:UG)", R.drawable.emo_skype_flag_ug);
		addPattern(SKYPE_EMOTICONS, "(flag:UA)", R.drawable.emo_skype_flag_ua);
		addPattern(SKYPE_EMOTICONS, "(flag:AE)", R.drawable.emo_skype_flag_ae);
		addPattern(SKYPE_EMOTICONS, "(flag:GB)", R.drawable.emo_skype_flag_gb);
		addPattern(SKYPE_EMOTICONS, "(flag:US)", R.drawable.emo_skype_flag_us);
		addPattern(SKYPE_EMOTICONS, "(flag:UY)", R.drawable.emo_skype_flag_uy);
		addPattern(SKYPE_EMOTICONS, "(flag:UZ)", R.drawable.emo_skype_flag_uz);
		addPattern(SKYPE_EMOTICONS, "(flag:VU)", R.drawable.emo_skype_flag_vu);
		addPattern(SKYPE_EMOTICONS, "(flag:VE)", R.drawable.emo_skype_flag_ve);
		addPattern(SKYPE_EMOTICONS, "(flag:VN)", R.drawable.emo_skype_flag_vn);
		addPattern(SKYPE_EMOTICONS, "(flag:WF)", R.drawable.emo_skype_flag_wf);
		addPattern(SKYPE_EMOTICONS, "(flag:YE)", R.drawable.emo_skype_flag_ye);
		addPattern(SKYPE_EMOTICONS, "(flag:ZM)", R.drawable.emo_skype_flag_zm);
		addPattern(SKYPE_EMOTICONS, "(flag:ZW)", R.drawable.emo_skype_flag_zw);
	}

	private static void addPattern(Map<Pattern, Integer> map, String smile,
			int resource) {
		map.put(Pattern.compile(Pattern.quote(smile)), resource);
	}

	private Emoticons() {
	}

	/**
	 * @param text
	 * @return new spannable.
	 */
	public static Spannable newSpannable(CharSequence text) {
		return spannableFactory.newSpannable(text);
	}

	/**
	 * @param context
	 * @param spannable
	 * @return Whether smiles have been added into <code>spannable</code>.
	 */
	public static boolean getSmiledText(Context context, Spannable spannable) {
		boolean hasChanges = false;
		Map<Pattern, Integer> emoticons = SettingsManager.interfaceSmiles();
		for (Entry<Pattern, Integer> entry : emoticons.entrySet()) {
			Matcher matcher = entry.getKey().matcher(spannable);
			while (matcher.find()) {
				boolean set = true;
				for (ImageSpan span : spannable.getSpans(matcher.start(),
						matcher.end(), ImageSpan.class))
					if (spannable.getSpanStart(span) >= matcher.start()
							&& spannable.getSpanEnd(span) <= matcher.end())
						spannable.removeSpan(span);
					else {
						set = false;
						break;
					}
				if (set) {
					spannable.setSpan(new ImageSpan(context, entry.getValue()),
							matcher.start(), matcher.end(),
							Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
					hasChanges = true;
				}
			}
		}
		return hasChanges;
	}

	/**
	 * @param context
	 * @param text
	 * @return New spannable with added smiles if needed.
	 */
	public static Spannable getSmiledText(Context context, CharSequence text) {
		Spannable spannable = spannableFactory.newSpannable(text);
		getSmiledText(context, spannable);
		return spannable;
	}

}
