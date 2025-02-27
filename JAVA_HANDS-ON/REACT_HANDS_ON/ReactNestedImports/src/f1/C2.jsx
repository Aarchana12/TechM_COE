import React, { Suspense, lazy } from 'react';
import C5 from '../../components/C5';  // Static Import (outside src)

// Dynamic Imports
const C3 = lazy(() => import('./C3'));  // inside src/f1
const C4 = lazy(() => import('../../components/C4'));  // outside src

function C2() {
    return (
        <div>
            <h3>Component 2</h3>
            <C5 /> {/* Static Import */}

            <Suspense fallback={<div>Loading Component 3...</div>}>
                <C3 />
            </Suspense>

            <Suspense fallback={<div>Loading Component 4...</div>}>
                <C4 />
            </Suspense>
        </div>
    );
}

export default C2;
