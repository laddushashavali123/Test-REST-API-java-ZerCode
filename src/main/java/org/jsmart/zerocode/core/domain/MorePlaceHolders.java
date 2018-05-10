package org.jsmart.zerocode.core.domain;

import org.jsmart.zerocode.core.placeholders.CustomPlaceHolders;

public @interface MorePlaceHolders {
    /**
     * @return  implementation class of more place holders e.g. $RANDOM.UUID
     */
    Class<? extends CustomPlaceHolders> value();

}
