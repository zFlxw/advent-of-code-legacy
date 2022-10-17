package com.github.zflxw.adventofcode.modules.y2015;

import com.github.zflxw.adventofcode.utils.AocModule;
import com.github.zflxw.adventofcode.utils.Module;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

@Module(year = "2015", day = "04")
public class Day04 extends AocModule {
    @Override
    public void solution(String rawInput, List<String> input) {
        for (int i = 0;; i++) {
            String hash = DigestUtils.md5Hex(rawInput + i).toUpperCase();
            // Replace with five / six zeros
            if (hash.startsWith("000000")) {
                System.out.println("Found matching hash! " + i);
                System.out.println("Hash: " + hash);
                break;
            }
        }
    }
}
