package android.support.v4.text;
 class BidiFormatter$DirectionalityEstimator {
    private static final byte[] DIR_TYPE_CACHE = None;
    private static final int DIR_TYPE_CACHE_SIZE = 1792;
    private int charIndex;
    private final boolean isHtml;
    private char lastChar;
    private final int length;
    private final String text;

    static BidiFormatter$DirectionalityEstimator()
    {
        byte[] v1_0 = new byte[1792];
        android.support.v4.text.BidiFormatter$DirectionalityEstimator.DIR_TYPE_CACHE = v1_0;
        int v0 = 0;
        while (v0 < 1792) {
            android.support.v4.text.BidiFormatter$DirectionalityEstimator.DIR_TYPE_CACHE[v0] = Character.getDirectionality(v0);
            v0++;
        }
        return;
    }

    BidiFormatter$DirectionalityEstimator(String p2, boolean p3)
    {
        this.text = p2;
        this.isHtml = p3;
        this.length = p2.length();
        return;
    }

    private static byte getCachedDirectionality(char p1)
    {
        byte v0_1;
        if (p1 >= 1792) {
            v0_1 = Character.getDirectionality(p1);
        } else {
            v0_1 = android.support.v4.text.BidiFormatter$DirectionalityEstimator.DIR_TYPE_CACHE[p1];
        }
        return v0_1;
    }

    private byte skipEntityBackward()
    {
        int v0 = this.charIndex;
        while (this.charIndex > 0) {
            char v1_4 = this.text;
            int v2_2 = (this.charIndex - 1);
            this.charIndex = v2_2;
            this.lastChar = v1_4.charAt(v2_2);
            if (this.lastChar != 38) {
                if (this.lastChar == 59) {
                    break;
                }
            } else {
                char v1_2 = 12;
            }
            return v1_2;
        }
        this.charIndex = v0;
        this.lastChar = 59;
        v1_2 = 13;
        return v1_2;
    }

    private byte skipEntityForward()
    {
        if ((int v0_3 == 59) || (this.charIndex >= this.length)) {
            return 12;
        } else {
            int v0_2 = this.text;
            int v1_2 = this.charIndex;
            this.charIndex = (v1_2 + 1);
            v0_3 = v0_2.charAt(v1_2);
            this.lastChar = v0_3;
        }
    }

    private byte skipTagBackward()
    {
        int v0 = this.charIndex;
        while (this.charIndex > 0) {
            char v2_9 = this.text;
            int v3_6 = (this.charIndex - 1);
            this.charIndex = v3_6;
            this.lastChar = v2_9.charAt(v3_6);
            if (this.lastChar != 60) {
                if (this.lastChar == 62) {
                    break;
                }
                if ((this.lastChar == 34) || (this.lastChar == 39)) {
                    char v1 = this.lastChar;
                    while (this.charIndex > 0) {
                        char v2_6 = this.text;
                        int v3_4 = (this.charIndex - 1);
                        this.charIndex = v3_4;
                        char v2_7 = v2_6.charAt(v3_4);
                        this.lastChar = v2_7;
                        if (v2_7 == v1) {
                            break;
                        }
                    }
                }
            } else {
                char v2_8 = 12;
            }
            return v2_8;
        }
        this.charIndex = v0;
        this.lastChar = 62;
        v2_8 = 13;
        return v2_8;
    }

    private byte skipTagForward()
    {
        int v0 = this.charIndex;
        while (this.charIndex < this.length) {
            char v2_10 = this.text;
            int v3_6 = this.charIndex;
            this.charIndex = (v3_6 + 1);
            this.lastChar = v2_10.charAt(v3_6);
            if (this.lastChar != 62) {
                if ((this.lastChar == 34) || (this.lastChar == 39)) {
                    char v1 = this.lastChar;
                    while (this.charIndex < this.length) {
                        char v2_6 = this.text;
                        int v3_5 = this.charIndex;
                        this.charIndex = (v3_5 + 1);
                        char v2_7 = v2_6.charAt(v3_5);
                        this.lastChar = v2_7;
                        if (v2_7 == v1) {
                            break;
                        }
                    }
                }
            } else {
                char v2_8 = 12;
            }
            return v2_8;
        }
        this.charIndex = v0;
        this.lastChar = 60;
        v2_8 = 13;
        return v2_8;
    }

    byte dirTypeBackward()
    {
        byte v1;
        this.lastChar = this.text.charAt((this.charIndex - 1));
        if (!Character.isLowSurrogate(this.lastChar)) {
            this.charIndex = (this.charIndex - 1);
            v1 = android.support.v4.text.BidiFormatter$DirectionalityEstimator.getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                if (this.lastChar != 62) {
                    if (this.lastChar == 59) {
                        v1 = this.skipEntityBackward();
                    }
                } else {
                    v1 = this.skipTagBackward();
                }
            }
        } else {
            int v0 = Character.codePointBefore(this.text, this.charIndex);
            this.charIndex = (this.charIndex - Character.charCount(v0));
            v1 = Character.getDirectionality(v0);
        }
        return v1;
    }

    byte dirTypeForward()
    {
        byte v1;
        this.lastChar = this.text.charAt(this.charIndex);
        if (!Character.isHighSurrogate(this.lastChar)) {
            this.charIndex = (this.charIndex + 1);
            v1 = android.support.v4.text.BidiFormatter$DirectionalityEstimator.getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                if (this.lastChar != 60) {
                    if (this.lastChar == 38) {
                        v1 = this.skipEntityForward();
                    }
                } else {
                    v1 = this.skipTagForward();
                }
            }
        } else {
            int v0 = Character.codePointAt(this.text, this.charIndex);
            this.charIndex = (this.charIndex + Character.charCount(v0));
            v1 = Character.getDirectionality(v0);
        }
        return v1;
    }

    int getEntryDir()
    {
        this.charIndex = 0;
        int v0 = 0;
        int v1 = 0;
        int v2 = 0;
        while ((this.charIndex < this.length) && (v2 == 0)) {
            switch (this.dirTypeForward()) {
                case 0:
                    if (v0 != 0) {
                        v2 = v0;
                    } else {
                        v1 = -1;
                    }
                    break;
                case 1:
                case 2:
                    if (v0 != 0) {
                        v2 = v0;
                    } else {
                        v1 = 1;
                    }
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                default:
                    v2 = v0;
                    break;
                case 14:
                case 15:
                    v0++;
                    v1 = -1;
                    break;
                case 16:
                case 17:
                    v0++;
                    v1 = 1;
                    break;
                case 18:
                    v0--;
                    v1 = 0;
                    break;
            }
            return v1;
        }
        if (v2 != 0) {
            if (v1 != 0) {
                return v1;
            }
            while (this.charIndex > 0) {
                switch (this.dirTypeBackward()) {
                    case 14:
                    case 15:
                        if (v2 != v0) {
                            v0--;
                        } else {
                            v1 = -1;
                        }
                    case 16:
                    case 17:
                        if (v2 != v0) {
                            v0--;
                        } else {
                            v1 = 1;
                        }
                        break;
                    case 18:
                        v0++;
                        break;
                    default:
                }
            }
            v1 = 0;
        } else {
            v1 = 0;
        }
        return v1;
    }

    int getExitDir()
    {
        int v2 = -1;
        this.charIndex = this.length;
        int v0 = 0;
        int v1 = 0;
        while (this.charIndex > 0) {
            switch (this.dirTypeBackward()) {
                case 0:
                    if (v0 != 0) {
                        if (v1 == 0) {
                            v1 = v0;
                        }
                    }
                    break;
                case 1:
                case 2:
                    if (v0 != 0) {
                        if (v1 == 0) {
                            v1 = v0;
                        }
                    } else {
                        v2 = 1;
                    }
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                default:
                    if (v1 == 0) {
                        v1 = v0;
                    }
                    break;
                case 14:
                case 15:
                    if (v1 != v0) {
                        v0--;
                    }
                    break;
                case 16:
                case 17:
                    if (v1 != v0) {
                        v0--;
                    } else {
                        v2 = 1;
                    }
                    break;
                case 18:
                    v0++;
                    break;
            }
            return v2;
        }
        v2 = 0;
        return v2;
    }
}
